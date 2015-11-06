package test.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class KeyBind {

	private final StringProperty string;
	private final StringProperty key;

	public KeyBind() {
		this(null, null);
	}

	public KeyBind(String string, String key) {
		this.string = new SimpleStringProperty(string);
		this.key = new SimpleStringProperty(key);
	}

}
