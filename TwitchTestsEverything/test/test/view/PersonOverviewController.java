package test.view;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;
import org.jibble.pircbot.PircBot;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import test.MainApp;
import test.model.Person;
import test.util.DateUtil;

public class PersonOverviewController {

	/*
	 * @FXML initializes by referencing our scene builder objects
	 */

	@FXML
	private TextArea chatTextArea;

	@FXML
	private TextField chatTextField;

	@FXML
	private TableView<Person> personTable;
	@FXML
	private TableColumn<Person, String> firstNameColumn;
	@FXML
	private TableColumn<Person, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;
	@FXML
	private Label streetLabel;
	@FXML
	private Label postalCodeLabel;
	@FXML
	private Label cityLabel;
	@FXML
	private Label birthdayLabel;

	// Reference to the main application.
	private MainApp mainApp;

	// Reference to our irc bot
	private TwitchBot bot;

	/**
	 * The constructor. The constructor is called before the initialize()
	 * method.
	 */
	public PersonOverviewController() {
	}

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Initialize the person table with the two columns.
		firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

		// Clear person details.
		showPersonDetails(null);

		// Listen for selection changes and show the person details when
		// changed.
		personTable.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;

		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 *
	 * @param person
	 *            the person or null
	 */
	private void showPersonDetails(Person person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());
			streetLabel.setText(person.getStreet());
			postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
			cityLabel.setText(person.getCity());

			birthdayLabel.setText(DateUtil.format(person.getBirthday()));
		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
			streetLabel.setText("");
			postalCodeLabel.setText("");
			cityLabel.setText("");
			birthdayLabel.setText("");
		}
	}

	/**
	 * Called when the user clicks on the delete button.
	 */
	@FXML
	private void handleDeletePerson() {
		int selectedIndex = personTable.getSelectionModel().getSelectedIndex();
		if (selectedIndex >= 0) {
			personTable.getItems().remove(selectedIndex);
		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the new button. Opens a dialog to edit
	 * details for a new person.
	 */
	@FXML
	private void handleNewPerson() {
		Person tempPerson = new Person();
		boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
		if (okClicked) {
			mainApp.getPersonData().add(tempPerson);
		}
	}

	/**
	 * Called when the user clicks the edit button. Opens a dialog to edit
	 * details for the selected person.
	 */
	@FXML
	private void handleEditPerson() {
		Person selectedPerson = personTable.getSelectionModel().getSelectedItem();
		if (selectedPerson != null) {
			boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
			if (okClicked) {
				showPersonDetails(selectedPerson);
			}

		} else {
			// Nothing selected.
			Alert alert = new Alert(AlertType.WARNING);
			alert.initOwner(mainApp.getPrimaryStage());
			alert.setTitle("No Selection");
			alert.setHeaderText("No Person Selected");
			alert.setContentText("Please select a person in the table.");

			alert.showAndWait();
		}
	}

	/**
	 * Called when the user clicks the send button. Sends the text message
	 * specified through Twitch IRC.
	 */
	@FXML
	private void handleSendMessage() {
		String message = chatTextField.getText();
		System.out.println(message);
		// chatTextField.setText(message);

		addMessage(bot.getName() + " " + message);
		if (bot != null) {
			bot.sendMessage("#TwitchCanPlayIt".toLowerCase(), message);
		} else {
			handleConnect();
			handleSendMessage();
		}
	}

	public void addMessage(String text) {
		chatTextArea.appendText("\n" + text);
	}

	public void log(String string) {
		addMessage("Error: " + string);
	}

	public void handleConnect() {
		if (bot == null) {
			bot = new TwitchBot(this);
			bot.setVerbose(true);
			try {
				bot.connect("irc.twitch.tv", 6667, "oauth:6kl7e8tg2x6khrpx6mizmzewt8hr8h");
			} catch (NickAlreadyInUseException e) {
				addMessage(e.getStackTrace().toString());
				bot = null;
			} catch (IOException e) {
				addMessage(e.getStackTrace().toString());
				bot = null;
			} catch (IrcException e) {
				addMessage(e.getStackTrace().toString());
				bot = null;
			}

			bot.joinChannel("#TwitchCanPlayIt".toLowerCase());
			addMessage(bot.getName() + " joined #TwitchCanPlayIt successfully.");

		} else {
			log("You are already connected.");
		}
	}

}

class TwitchBot extends PircBot {

	private PersonOverviewController controller;

	public TwitchBot(PersonOverviewController controller) {
		this.setName("TwitchCanPlayIt");
		this.controller = controller;
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		controller.addMessage(sender + ": " + message);
		// Change the section that says VK_[key] to correspond to your game
		// controls, but don't get rid of the VK_
		if (message.equalsIgnoreCase("up")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_W);
				r.keyRelease(KeyEvent.VK_W);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("down")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_S);
				r.keyRelease(KeyEvent.VK_S);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("left")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_A);
				r.keyRelease(KeyEvent.VK_A);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("right")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_D);
				r.keyRelease(KeyEvent.VK_D);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("b")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_Z);
				r.keyRelease(KeyEvent.VK_Z);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("a")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_X);
				r.keyRelease(KeyEvent.VK_X);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("start")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_E);
				r.keyRelease(KeyEvent.VK_E);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

		if (message.equalsIgnoreCase("select")) {
			try {
				Robot r = new Robot();
				r.keyPress(KeyEvent.VK_Q);
				r.keyRelease(KeyEvent.VK_Q);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}
}
