package test.view;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.jibble.pircbot.PircBot;

import javafx.collections.ObservableList;
import test.MainApp;
import test.model.KeyBind;

public class TwitchBot extends PircBot {

	private static final String A = "a";
	private static final String ADD = "add";
	private static final String AGAIN = "again";
	private static final String ALT = "alt";
	private static final String AMPERSAND = "ampersand";
	private static final String ASTERISK = "asterisk";
	private static final String AT = "at";
	private static final String B = "b";
	private static final String BACKQUOTE = "backquote";
	private static final String BACKSLASH = "backslash";
	private static final String BACKSPACE = "backspace";
	private static final String C = "c";
	private static final String CANCEL = "cancel";
	private static final String CAPSLOCK = "capslock";
	private static final String CIRCUMFLEX = "circumflex";
	private static final String CLEAR = "clear";
	private static final String CLOSEBRACKET = "closebracket";
	private static final String COLON = "colon";
	private static final String COMMA = "comma";
	private static final String CONTROL = "control";
	private static final String COPY = "copy";
	private static final String CUT = "cut";
	private static final String D = "d";
	private static final String DECIMAL = "decimal";
	private static final String DOLLAR = "dollar";
	private static final String DOWN = "down";
	private static final String E = "e";
	private static final String END = "end";
	private static final String ENTER = "enter";
	private static final String EQUALS = "equals";
	private static final String ESCAPE = "escape";
	private static final String EUROSIGN = "eurosign";
	private static final String EXCLAMATIONMARK = "exclamationmark";
	private static final String F = "f";
	private static final String F1 = "f1";
	private static final String F10 = "f10";
	private static final String F11 = "f11";
	private static final String F12 = "f12";
	private static final String F13 = "f13";
	private static final String F14 = "f14";
	private static final String F15 = "f15";
	private static final String F16 = "f16";
	private static final String F17 = "f17";
	private static final String F18 = "f18";
	private static final String F19 = "f19";
	private static final String F2 = "f2";
	private static final String F20 = "f20";
	private static final String F21 = "f21";
	private static final String F22 = "f22";
	private static final String F23 = "f23";
	private static final String F24 = "f24";
	private static final String F3 = "f3";
	private static final String F4 = "f4";
	private static final String F5 = "f5";
	private static final String F6 = "f6";
	private static final String F7 = "f7";
	private static final String F8 = "f8";
	private static final String F9 = "f9";
	private static final String FIND = "find";
	private static final String G = "g";
	private static final String GREATER = "greater";
	private static final String H = "h";
	private static final String HELP = "help";
	private static final String HOME = "home";
	private static final String I = "i";
	private static final String INSERT = "insert";
	private static final String J = "j";
	private static final String K = "k";
	private static final String L = "l";
	private static final String LEFT = "left";
	private static final String LEFTPARENTHESIS = "leftparenthesis";
	private static final String LESS = "less";
	private static final String M = "m";
	private static final String META = "meta";
	private static final String MINUS = "minus";
	private static final String MULTIPLY = "multiply";
	private static final String N = "n";
	private static final String NUM_0 = "0";
	private static final String NUM_1 = "1";
	private static final String NUM_2 = "2";
	private static final String NUM_3 = "3";
	private static final String NUM_4 = "4";
	private static final String NUM_5 = "5";
	private static final String NUM_6 = "6";
	private static final String NUM_7 = "7";
	private static final String NUM_8 = "8";
	private static final String NUM_9 = "9";
	private static final String NUMBERSIGN = "numbersign";
	private static final String NUMLOCK = "numlock";
	private static final String NUMPAD0 = "numpad0";
	private static final String NUMPAD1 = "numpad1";
	private static final String NUMPAD2 = "numpad2";
	private static final String NUMPAD3 = "numpad3";
	private static final String NUMPAD4 = "numpad4";
	private static final String NUMPAD5 = "numpad5";
	private static final String NUMPAD6 = "numpad6";
	private static final String NUMPAD7 = "numpad7";
	private static final String NUMPAD8 = "numpad8";
	private static final String NUMPAD9 = "numpad9";
	private static final String NUMPADDOWN = "numpaddown";
	private static final String NUMPADLEFT = "numpadleft";
	private static final String NUMPADRIGHT = "numpadright";
	private static final String NUMPADUP = "numpadup";
	private static final String O = "o";
	private static final String OPENBRACKET = "openbracket";
	private static final String P = "p";
	private static final String PAGEUP = "pageup";
	private static final String PASTE = "paste";
	private static final String PAUSE = "pause";
	private static final String PERIOD = "period";
	private static final String PLUS = "plus";
	private static final String PRINTSCREEN = "printscreen";
	private static final String Q = "q";
	private static final String QUOTE = "quote";
	private static final String R = "r";
	private static final String RIGHT = "right";
	private static final String RIGHTPARENTHESIS = "rightparenthesis";
	private static final String S = "s";
	private static final String SCROLLOCK = "scrollock";
	private static final String SEMICOLON = "semicolon";
	private static final String SHIFT = "shift";
	private static final String SLASH = "slash";
	private static final String SPACE = "space";
	private static final String SUBTRACT = "subtract";
	private static final String T = "t";
	private static final String TAB = "tab";
	private static final String U = "u";
	private static final String UNDERSCORE = "underscore";
	private static final String UNDO = "undo";
	private static final String UP = "up";
	private static final String V = "v";
	private static final String W = "w";
	private static final String WINDOWS = "windows";
	private static final String X = "x";
	private static final String Y = "y";
	private MainApp app;
	private PersonOverviewController controller;
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

	public int getKeyNumber(String key) {

		key = key.toLowerCase();

		switch (key) {
		case ENTER:
			return KeyEvent.VK_ENTER;
		case BACKSPACE:
			return KeyEvent.VK_BACK_SPACE;
		case TAB:
			return KeyEvent.VK_TAB;
		case CANCEL:
			return KeyEvent.VK_CANCEL;
		case CLEAR:
			return KeyEvent.VK_CLEAR;
		case SHIFT:
			return KeyEvent.VK_SHIFT;
		case CONTROL:
			return KeyEvent.VK_CONTROL;
		case ALT:
			return KeyEvent.VK_ALT;
		case PAUSE:
			return KeyEvent.VK_PAUSE;
		case CAPSLOCK:
			return KeyEvent.VK_CAPS_LOCK;
		case ESCAPE:
			return KeyEvent.VK_ESCAPE;
		case SPACE:
			return KeyEvent.VK_SPACE;
		case PAGEUP:
			return KeyEvent.VK_PAGE_UP;
		case END:
			return KeyEvent.VK_END;
		case HOME:
			return KeyEvent.VK_HOME;
		case LEFT:
			return KeyEvent.VK_LEFT;
		case UP:
			return KeyEvent.VK_UP;
		case RIGHT:
			return KeyEvent.VK_RIGHT;
		case DOWN:
			return KeyEvent.VK_DOWN;
		case COMMA:
			return KeyEvent.VK_COMMA;
		case MINUS:
			return KeyEvent.VK_LEFT;
		case PERIOD:
			return KeyEvent.VK_PERIOD;
		case SLASH:
			return KeyEvent.VK_SLASH;
		case NUM_0:
			return KeyEvent.VK_0;
		case NUM_1:
			return KeyEvent.VK_1;
		case NUM_2:
			return KeyEvent.VK_2;
		case NUM_3:
			return KeyEvent.VK_3;
		case NUM_4:
			return KeyEvent.VK_4;
		case NUM_5:
			return KeyEvent.VK_5;
		case NUM_6:
			return KeyEvent.VK_6;
		case NUM_7:
			return KeyEvent.VK_7;
		case NUM_8:
			return KeyEvent.VK_8;
		case NUM_9:
			return KeyEvent.VK_9;
		case SEMICOLON:
			return KeyEvent.VK_SEMICOLON;
		case EQUALS:
			return KeyEvent.VK_EQUALS;
		case A:
			return KeyEvent.VK_A;
		case B:
			return KeyEvent.VK_B;
		case C:
			return KeyEvent.VK_C;
		case D:
			return KeyEvent.VK_D;
		case E:
			return KeyEvent.VK_E;
		case F:
			return KeyEvent.VK_F;
		case G:
			return KeyEvent.VK_G;
		case H:
			return KeyEvent.VK_H;
		case I:
			return KeyEvent.VK_I;
		case J:
			return KeyEvent.VK_J;
		case K:
			return KeyEvent.VK_K;
		case L:
			return KeyEvent.VK_L;
		case M:
			return KeyEvent.VK_M;
		case N:
			return KeyEvent.VK_N;
		case O:
			return KeyEvent.VK_O;
		case P:
			return KeyEvent.VK_P;
		case Q:
			return KeyEvent.VK_Q;
		case R:
			return KeyEvent.VK_R;
		case S:
			return KeyEvent.VK_S;
		case T:
			return KeyEvent.VK_T;
		case U:
			return KeyEvent.VK_U;
		case V:
			return KeyEvent.VK_V;
		case W:
			return KeyEvent.VK_W;
		case X:
			return KeyEvent.VK_X;
		case Y:
			return KeyEvent.VK_Y;
		case OPENBRACKET:
			return KeyEvent.VK_OPEN_BRACKET;
		case BACKSLASH:
			return KeyEvent.VK_BACK_SLASH;
		case CLOSEBRACKET:
			return KeyEvent.VK_CLOSE_BRACKET;
		case NUMPAD0:
			return KeyEvent.VK_NUMPAD0;
		case NUMPAD1:
			return KeyEvent.VK_NUMPAD1;
		case NUMPAD2:
			return KeyEvent.VK_NUMPAD2;
		case NUMPAD3:
			return KeyEvent.VK_NUMPAD3;
		case NUMPAD4:
			return KeyEvent.VK_NUMPAD4;
		case NUMPAD5:
			return KeyEvent.VK_NUMPAD5;
		case NUMPAD6:
			return KeyEvent.VK_NUMPAD6;
		case NUMPAD7:
			return KeyEvent.VK_NUMPAD7;
		case NUMPAD8:
			return KeyEvent.VK_NUMPAD8;
		case NUMPAD9:
			return KeyEvent.VK_NUMPAD9;
		case MULTIPLY:
			return KeyEvent.VK_MULTIPLY;
		case ADD:
			return KeyEvent.VK_ADD;
		case SUBTRACT:
			return KeyEvent.VK_SUBTRACT;
		case DECIMAL:
			return KeyEvent.VK_DECIMAL;
		case NUMLOCK:
			return KeyEvent.VK_NUM_LOCK;
		case SCROLLOCK:
			return KeyEvent.VK_SCROLL_LOCK;
		case F1:
			return KeyEvent.VK_F1;
		case F2:
			return KeyEvent.VK_F2;
		case F3:
			return KeyEvent.VK_F3;
		case F4:
			return KeyEvent.VK_F4;
		case F5:
			return KeyEvent.VK_F5;
		case F6:
			return KeyEvent.VK_F6;
		case F7:
			return KeyEvent.VK_F7;
		case F8:
			return KeyEvent.VK_F8;
		case F9:
			return KeyEvent.VK_F9;
		case F10:
			return KeyEvent.VK_F10;
		case F11:
			return KeyEvent.VK_F11;
		case F12:
			return KeyEvent.VK_F12;
		case F13:
			return KeyEvent.VK_F13;
		case F14:
			return KeyEvent.VK_F14;
		case F15:
			return KeyEvent.VK_F15;
		case F16:
			return KeyEvent.VK_F16;
		case F17:
			return KeyEvent.VK_F17;
		case F18:
			return KeyEvent.VK_F18;
		case F19:
			return KeyEvent.VK_F19;
		case F20:
			return KeyEvent.VK_F20;
		case F21:
			return KeyEvent.VK_F21;
		case F22:
			return KeyEvent.VK_F22;
		case F23:
			return KeyEvent.VK_F23;
		case F24:
			return KeyEvent.VK_F24;
		case PRINTSCREEN:
			return KeyEvent.VK_PRINTSCREEN;
		case INSERT:
			return KeyEvent.VK_INSERT;
		case HELP:
			return KeyEvent.VK_HELP;
		case META:
			return KeyEvent.VK_META;
		case BACKQUOTE:
			return KeyEvent.VK_BACK_QUOTE;
		case QUOTE:
			return KeyEvent.VK_QUOTE;
		case NUMPADUP:
			return KeyEvent.VK_KP_UP;
		case NUMPADDOWN:
			return KeyEvent.VK_KP_DOWN;
		case NUMPADLEFT:
			return KeyEvent.VK_KP_LEFT;
		case NUMPADRIGHT:
			return KeyEvent.VK_KP_RIGHT;
		case AMPERSAND:
			return KeyEvent.VK_AMPERSAND;
		case ASTERISK:
			return KeyEvent.VK_ASTERISK;
		case LESS:
			return KeyEvent.VK_LESS;
		case GREATER:
			return KeyEvent.VK_GREATER;
		case AT:
			return KeyEvent.VK_AT;
		case COLON:
			return KeyEvent.VK_COLON;
		case CIRCUMFLEX:
			return KeyEvent.VK_CIRCUMFLEX;
		case DOLLAR:
			return KeyEvent.VK_DOLLAR;
		case EUROSIGN:
			return KeyEvent.VK_EURO_SIGN;
		case EXCLAMATIONMARK:
			return KeyEvent.VK_EXCLAMATION_MARK;
		case LEFTPARENTHESIS:
			return KeyEvent.VK_LEFT_PARENTHESIS;
		case NUMBERSIGN:
			return KeyEvent.VK_NUMBER_SIGN;
		case PLUS:
			return KeyEvent.VK_PLUS;
		case RIGHTPARENTHESIS:
			return KeyEvent.VK_RIGHT_PARENTHESIS;
		case UNDERSCORE:
			return KeyEvent.VK_UNDERSCORE;
		case CUT:
			return KeyEvent.VK_CUT;
		case COPY:
			return KeyEvent.VK_COPY;
		case PASTE:
			return KeyEvent.VK_PASTE;
		case UNDO:
			return KeyEvent.VK_UNDO;
		case AGAIN:
			return KeyEvent.VK_AGAIN;
		case FIND:
			return KeyEvent.VK_FIND;
		case WINDOWS:
			return KeyEvent.VK_WINDOWS;

		default:
			return 0;

		}

	}

	public void handleInput(String message) {

		ObservableList<KeyBind> keyBinds = app.getPersonData();

		for (KeyBind keyBind : keyBinds) {
			System.out.println(keyBind.getFirstName() + " + " + message);

			if (message == keyBind.getFirstName().toLowerCase() || message.equalsIgnoreCase(keyBind.getFirstName())) {
				System.out.println("WINNER!");

				int keyNumber = getKeyNumber(message);
				if (keyNumber != 0) {
					try {
						robot = new Robot();
						robot.keyPress(keyNumber);
						robot.keyRelease(keyNumber);
					} catch (AWTException e) {
						e.printStackTrace();
					}
				}

			}

		}

	}

	public void onMessage(String channel, String sender, String login, String hostname, String message) {
		controller.addMessage(sender + ": " + message);

		handleInput(message);

	}
}
