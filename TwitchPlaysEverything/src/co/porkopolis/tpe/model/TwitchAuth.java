package co.porkopolis.tpe.model;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class TwitchAuth {

	public static void main(String[] args) throws IOException, URISyntaxException {
		if (Desktop.isDesktopSupported()) {
			Desktop.getDesktop()
					.browse(new URI(
							"https://api.twitch.tv/kraken/oauth2/authorize?response_type=token&client_id=sxw2y2lnhn74npb8qwdp5vmyviv7mus&redirect_uri=http:/"
									+ "/localhost&scope=chat_login"));
		}
	}

}
