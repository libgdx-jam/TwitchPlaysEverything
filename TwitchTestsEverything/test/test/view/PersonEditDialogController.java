package test.view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import test.model.KeyBind;

/**
 * Dialog to edit details of a person.
 *
 * @author Marco Jakob
 */
public class PersonEditDialogController {

	@FXML
	private TextField firstNameField;

	@FXML
	private ComboBox<String> comboBox;

	private Stage dialogStage;
	private KeyBind person;
	private boolean okClicked = false;

	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {

		comboBox.getItems().clear();

		comboBox.getItems().addAll(

		"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "add", "again", "alt", "ampersand", "asterisk", "at",
				"b", "backquote", "backslash", "backspace", "c", "cancel", "capslock", "circumflex", "clear",
				"closebracket", "colon", "comma", "control", "copy", "cut", "d", "decimal", "dollar", "down", "e",
				"end", "enter", "equals", "escape", "eurosign", "exclamationmark", "f", "f1", "f10", "f11", "f12",
				"f13", "f14", "f15", "f16", "f17", "f18", "f19", "f2", "f20", "f21", "f22", "f23", "f24", "f3", "f4",
				"f5", "f6", "f7", "f8", "f9", "find", "g", "greater", "h", "help", "home", "i", "insert", "j", "k", "l",
				"left", "leftparenthesis", "less", "m", "meta", "minus", "multiply", "n", "numbersign", "numlock",
				"numpad0", "numpad1", "numpad2", "numpad3", "numpad4", "numpad5", "numpad6", "numpad7", "numpad8",
				"numpad9", "numpaddown", "numpadleft", "numpadright", "numpadup", "o", "openbracket", "p", "pageup",
				"paste", "pause", "period", "plus", "printscreen", "q", "quote", "r", "right", "rightparenthesis", "s",
				"scrollock", "semicolon", "shift", "slash", "space", "subtract", "t", "tab", "u", "underscore", "undo",
				"up", "v", "w", "windows", "x", "y", "z"

		);

	}

	/**
	 * Sets the stage of this dialog.
	 *
	 * @param dialogStage
	 */
	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	/**
	 * Sets the person to be edited in the dialog.
	 *
	 * @param person
	 */
	public void setPerson(KeyBind person) {
		this.person = person;

		firstNameField.setText(person.getFirstName());
		comboBox.setAccessibleHelp(person.getLastName());

	}

	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
		return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleOk() {
		if (isInputValid()) {
			person.setFirstName(firstNameField.getText());
			person.setLastName(comboBox.getSelectionModel().getSelectedItem());

			okClicked = true;
			dialogStage.close();
		}
	}

	/**
	 * Called when the user clicks cancel.
	 */
	@FXML
	private void handleCancel() {
		dialogStage.close();
	}

	/**
	 * Validates the user input in the text fields.
	 *
	 * @return true if the input is valid
	 */
	private boolean isInputValid() {
		String errorMessage = "";

		if (firstNameField.getText() == null || firstNameField.getText().length() == 0) {
			errorMessage += "No valid first name!\n";
		}

		if (comboBox.getSelectionModel().isEmpty()) {
			errorMessage += "No selection was made!/n";
		}

		if (errorMessage.length() == 0) {
			return true;
		} else {
			// Show the error message.
			Alert alert = new Alert(AlertType.ERROR);
			alert.initOwner(dialogStage);
			alert.setTitle("Invalid Fields");
			alert.setHeaderText("Please correct invalid fields");
			alert.setContentText(errorMessage);

			alert.showAndWait();

			return false;
		}
	}
}