package test.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jibble.pircbot.PircBot;

import javafx.collections.ObservableList;
import test.MainApp;
import test.model.KeyBind;

public class TwitchBot extends PircBot {

	private PersonOverviewController controller;
	private MainApp app;
	private Robot robot;

	public TwitchBot(PersonOverviewController controller, MainApp mainApp) {
		this.setName("TwitchCanPlayIt");
		this.controller = controller;
		app = mainApp;
		try {
			robot = new Robot();
			robot.setAutoDelay(80);
			robot.setAutoWaitForIdle(true);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		controller.addMessage(sender + ": " + message);

		handleInput(message);

	}

	public void handleInput(String message) {

		ObservableList<KeyBind> keyBinds = app.getPersonData();

		for (KeyBind keyBind : keyBinds) {
			System.out.println(keyBind.getFirstName()+ " + " + message);

			if (message == keyBind.getFirstName().toLowerCase()) {
				System.out.println("WINNER!");

			}

			int keyNumber = getKeyNumber(message);
			if (keyNumber != 0)
				try {
					robot = new Robot();
					robot.keyPress(keyNumber);
					robot.keyRelease(keyNumber);
				} catch (AWTException e) {
					e.printStackTrace();
				}

		}

	}

	public int getKeyNumber(String key) {

		key = key.toLowerCase();

		switch (key) {
		case "enter":
			return KeyEvent.VK_ENTER;
		case "backspace":
			return KeyEvent.VK_BACK_SPACE;
		case "tab":
			return KeyEvent.VK_TAB;
		case "cancel":
			return KeyEvent.VK_CANCEL;
		case "clear":
			return KeyEvent.VK_CLEAR;
		case "shift":
			return KeyEvent.VK_SHIFT;
		case "control":
			return KeyEvent.VK_CONTROL;
		case "alt":
			return KeyEvent.VK_ALT;
		case "pause":
			return KeyEvent.VK_PAUSE;
		case "capslock":
			return KeyEvent.VK_CAPS_LOCK;
		case "escape":
			return KeyEvent.VK_ESCAPE;
		case "space":
			return KeyEvent.VK_SPACE;
		case "pageup":
			return KeyEvent.VK_PAGE_UP;
		case "end":
			return KeyEvent.VK_END;
		case "home":
			return KeyEvent.VK_HOME;
		case "left":
			return KeyEvent.VK_LEFT;
		case "up":
			return KeyEvent.VK_UP;
		case "right":
			return KeyEvent.VK_RIGHT;
		case "down":
			return KeyEvent.VK_DOWN;
		case "comma":
			return KeyEvent.VK_COMMA;
		case "minus":
			return KeyEvent.VK_LEFT;
		case "period":
			return KeyEvent.VK_PERIOD;
		case "slash":
			return KeyEvent.VK_SLASH;
		case "0":
			return KeyEvent.VK_0;
		case "1":
			return KeyEvent.VK_1;
		case "2":
			return KeyEvent.VK_2;
		case "3":
			return KeyEvent.VK_3;
		case "4":
			return KeyEvent.VK_4;
		case "5":
			return KeyEvent.VK_5;
		case "6":
			return KeyEvent.VK_6;
		case "7":
			return KeyEvent.VK_7;
		case "8":
			return KeyEvent.VK_8;
		case "9":
			return KeyEvent.VK_9;
		case "semicolon":
			return KeyEvent.VK_SEMICOLON;
		case "equals":
			return KeyEvent.VK_EQUALS;
		case "a":
			return KeyEvent.VK_A;
		case "b":
			return KeyEvent.VK_B;
		case "c":
			return KeyEvent.VK_C;
		case "d":
			return KeyEvent.VK_D;
		case "e":
			return KeyEvent.VK_E;
		case "f":
			return KeyEvent.VK_F;
		case "g":
			return KeyEvent.VK_G;
		case "h":
			return KeyEvent.VK_H;
		case "i":
			return KeyEvent.VK_I;
		case "j":
			return KeyEvent.VK_J;
		case "k":
			return KeyEvent.VK_K;
		case "l":
			return KeyEvent.VK_L;
		case "m":
			return KeyEvent.VK_M;
		case "n":
			return KeyEvent.VK_N;
		case "o":
			return KeyEvent.VK_O;
		case "p":
			return KeyEvent.VK_P;
		case "q":
			return KeyEvent.VK_Q;
		case "r":
			return KeyEvent.VK_R;
		case "s":
			return KeyEvent.VK_S;
		case "t":
			return KeyEvent.VK_T;
		case "u":
			return KeyEvent.VK_U;
		case "v":
			return KeyEvent.VK_V;
		case "w":
			return KeyEvent.VK_W;
		case "x":
			return KeyEvent.VK_X;
		case "y":
			return KeyEvent.VK_Y;
		case "openbracket":
			return KeyEvent.VK_OPEN_BRACKET;
		case "backslash":
			return KeyEvent.VK_BACK_SLASH;
		case "closebracket":
			return KeyEvent.VK_CLOSE_BRACKET;
		case "numpad0":
			return KeyEvent.VK_NUMPAD0;
		case "numpad1":
			return KeyEvent.VK_NUMPAD1;
		case "numpad2":
			return KeyEvent.VK_NUMPAD2;
		case "numpad3":
			return KeyEvent.VK_NUMPAD3;
		case "numpad4":
			return KeyEvent.VK_NUMPAD4;
		case "numpad5":
			return KeyEvent.VK_NUMPAD5;
		case "numpad6":
			return KeyEvent.VK_NUMPAD6;
		case "numpad7":
			return KeyEvent.VK_NUMPAD7;
		case "numpad8":
			return KeyEvent.VK_NUMPAD8;
		case "numpad9":
			return KeyEvent.VK_NUMPAD9;
		case "multiply":
			return KeyEvent.VK_MULTIPLY;
		case "add":
			return KeyEvent.VK_ADD;
		case "subtract":
			return KeyEvent.VK_SUBTRACT;
		case "decimal":
			return KeyEvent.VK_DECIMAL;
		case "numlock":
			return KeyEvent.VK_NUM_LOCK;
		case "scrollock":
			return KeyEvent.VK_SCROLL_LOCK;
		case "f1":
			return KeyEvent.VK_F1;
		case "f2":
			return KeyEvent.VK_F2;
		case "f3":
			return KeyEvent.VK_F3;
		case "f4":
			return KeyEvent.VK_F4;
		case "f5":
			return KeyEvent.VK_F5;
		case "f6":
			return KeyEvent.VK_F6;
		case "f7":
			return KeyEvent.VK_F7;
		case "f8":
			return KeyEvent.VK_F8;
		case "f9":
			return KeyEvent.VK_F9;
		case "f10":
			return KeyEvent.VK_F10;
		case "f11":
			return KeyEvent.VK_F11;
		case "f12":
			return KeyEvent.VK_F12;
		case "f13":
			return KeyEvent.VK_F13;
		case "f14":
			return KeyEvent.VK_F14;
		case "f15":
			return KeyEvent.VK_F15;
		case "f16":
			return KeyEvent.VK_F16;
		case "f17":
			return KeyEvent.VK_F17;
		case "f18":
			return KeyEvent.VK_F18;
		case "f19":
			return KeyEvent.VK_F19;
		case "f20":
			return KeyEvent.VK_F20;
		case "f21":
			return KeyEvent.VK_F21;
		case "f22":
			return KeyEvent.VK_F22;
		case "f23":
			return KeyEvent.VK_F23;
		case "f24":
			return KeyEvent.VK_F24;
		case "printscreen":
			return KeyEvent.VK_PRINTSCREEN;
		case "insert":
			return KeyEvent.VK_INSERT;
		case "help":
			return KeyEvent.VK_HELP;
		case "meta":
			return KeyEvent.VK_META;
		case "backquote":
			return KeyEvent.VK_BACK_QUOTE;
		case "quote":
			return KeyEvent.VK_QUOTE;
		case "numpadup":
			return KeyEvent.VK_KP_UP;
		case "numpaddown":
			return KeyEvent.VK_KP_DOWN;
		case "numpadleft":
			return KeyEvent.VK_KP_LEFT;
		case "numpadright":
			return KeyEvent.VK_KP_RIGHT;
		case "ampersand":
			return KeyEvent.VK_AMPERSAND;
		case "asterisk":
			return KeyEvent.VK_ASTERISK;
		case "less":
			return KeyEvent.VK_LESS;
		case "greater":
			return KeyEvent.VK_GREATER;
		case "at":
			return KeyEvent.VK_AT;
		case "colon":
			return KeyEvent.VK_COLON;
		case "circumflex":
			return KeyEvent.VK_CIRCUMFLEX;
		case "dollar":
			return KeyEvent.VK_DOLLAR;
		case "eurosign":
			return KeyEvent.VK_EURO_SIGN;
		case "exclamationmark":
			return KeyEvent.VK_EXCLAMATION_MARK;
		case "leftparenthesis":
			return KeyEvent.VK_LEFT_PARENTHESIS;
		case "numbersign":
			return KeyEvent.VK_NUMBER_SIGN;
		case "plus":
			return KeyEvent.VK_PLUS;
		case "rightparenthesis":
			return KeyEvent.VK_RIGHT_PARENTHESIS;
		case "underscore":
			return KeyEvent.VK_UNDERSCORE;
		case "cut":
			return KeyEvent.VK_CUT;
		case "copy":
			return KeyEvent.VK_COPY;
		case "paste":
			return KeyEvent.VK_PASTE;
		case "undo":
			return KeyEvent.VK_UNDO;
		case "again":
			return KeyEvent.VK_AGAIN;
		case "find":
			return KeyEvent.VK_FIND;
		case "windows":
			return KeyEvent.VK_WINDOWS;

		default:
			return 0;

		}

	}
}
