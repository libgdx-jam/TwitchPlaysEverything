package co.porkopolis.tpe.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class TestController implements Initializable {

	@FXML // fx:id="loginButton"
	private Button loginButton; // Value injected by FXMLLoader

	@Override // This method is called by the FXMLLoader when initialization is
				// complete
	public void initialize(URL fxmlFileLocation, ResourceBundle resources) {
		assert loginButton != null : "fx:id=\"loginButton\" was not injected: check your FXML file 'AuthenticationView.fxml'.";

		// initialize your logic here: all @FXML variables will have been
		// injected

		loginButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("That was easy, wasn't it?");
			}
		});

	}

}