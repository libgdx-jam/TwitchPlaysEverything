package test.view;

import java.io.IOException;

import org.jibble.pircbot.IrcException;
import org.jibble.pircbot.NickAlreadyInUseException;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import test.MainApp;
import test.model.KeyBind;

public class PersonOverviewController {

	/*
	 * @FXML initializes by referencing our scene builder objects
	 */

	@FXML
	private TextArea chatTextArea;

	@FXML
	private TextField chatTextField;

	@FXML
	private TableView<KeyBind> personTable;
	@FXML
	private TableColumn<KeyBind, String> firstNameColumn;
	@FXML
	private TableColumn<KeyBind, String> lastNameColumn;

	@FXML
	private Label firstNameLabel;
	@FXML
	private Label lastNameLabel;

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

		chatTextField.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent keyEvent) {
				if (keyEvent.getCode() == KeyCode.ENTER) {
					handleSendMessage();
				}
			}
		});

	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param mainApp
	 */
	public void setMainApp(MainApp mainApp) {
		this.mainApp = mainApp;
		this.bot = mainApp.getTwitchBot();

		// Add observable list data to the table
		personTable.setItems(mainApp.getPersonData());
	}

	public MainApp getMainApp() {
		return mainApp;
	}

	/**
	 * Fills all text fields to show details about the person. If the specified
	 * person is null, all text fields are cleared.
	 *
	 * @param person
	 *            the person or null
	 */
	private void showPersonDetails(KeyBind person) {
		if (person != null) {
			// Fill the labels with info from the person object.
			firstNameLabel.setText(person.getFirstName());
			lastNameLabel.setText(person.getLastName());

		} else {
			// Person is null, remove all the text.
			firstNameLabel.setText("");
			lastNameLabel.setText("");
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
		KeyBind tempPerson = new KeyBind();
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
		KeyBind selectedPerson = personTable.getSelectionModel().getSelectedItem();

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

		if (bot != null && bot.isConnected()) {
			addMessage(bot.getName() + ": " + message);
			bot.sendMessage("#TwitchCanPlayIt".toLowerCase(), message);
			chatTextField.setText("");

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
			bot = new TwitchBot(this, mainApp);
			bot.setVerbose(true);

		}

		if (!bot.isConnected()) {

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
