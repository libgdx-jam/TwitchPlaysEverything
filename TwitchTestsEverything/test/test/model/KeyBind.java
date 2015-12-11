package test.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Model class for a Person.
 *
 * @author Marco Jakob
 */
public class KeyBind {

	private final StringProperty string;
	private final StringProperty keybind;

	/**
	 * Default constructor.
	 */
	public KeyBind() {
		this(null, null);
	}

	/**
	 * Constructor with some initial data.
	 *
	 * @param firstName
	 * @param lastName
	 */
	public KeyBind(String firstName, String lastName) {
		this.string = new SimpleStringProperty(firstName);
		this.keybind = new SimpleStringProperty(lastName);

	}

	public String getFirstName() {
		return string.get();
	}

	public void setFirstName(String firstName) {
		this.string.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return string;
	}

	public String getLastName() {
		return keybind.get();
	}

	public void setLastName(String lastName) {
		this.keybind.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return keybind;
	}

}