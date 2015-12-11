package test.view;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import test.WebTest2;

public class WebViewController {

	@FXML
	private WebView web;

	private WebEngine engine;

	private WebTest2 main;

	public WebViewController() {
	}

	@FXML
	private void initialize() {
		engine = web.getEngine();

	}

	public void setMainApp(WebTest2 main) {
		this.main = main;
	}

}
