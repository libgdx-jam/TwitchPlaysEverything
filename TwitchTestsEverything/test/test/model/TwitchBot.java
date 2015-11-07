package test.model;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jibble.pircbot.PircBot;

public class TwitchBot extends PircBot {

	public TwitchBot() {
		this.setName("TwitchCanPlayIt");
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		
		
		
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