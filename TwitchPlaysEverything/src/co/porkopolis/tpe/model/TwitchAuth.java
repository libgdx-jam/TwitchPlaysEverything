package co.porkopolis.tpe.model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TwitchAuth {

	String clientID;
	String redirectURL;
	String scope;
	final static String state = "secretrandomstring";

	public String uri;

	public void authorize(String clientID, String redirectURL, String scope, String state)
			throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported()) {
			uri = "https://api.twitch.tv/kraken/oauth2/authorize?response_type=code&client_id=" + clientID
					+ "&redirect_uri=" + redirectURL + "&scope=" + scope + "&state=" + state;

			Desktop.getDesktop().browse(new URI(uri));
		}

	}

	public static void main(String[] args) throws IOException, URISyntaxException {
		TwitchAuth twitch = new TwitchAuth();
		twitch.authorize("sxw2y2lnhn74npb8qwdp5vmyviv7mus", "http://localhost", "chat_login", state);
	}

}
