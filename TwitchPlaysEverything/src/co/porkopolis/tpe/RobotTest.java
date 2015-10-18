package co.porkopolis.tpe;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class RobotTest {
	public static void main(String[] args) throws AWTException {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		Robot robot = new Robot();

		while (true) {
			System.out.println("type a word: ");
			input = scanner.next();

			switch (input) {
			case "up":
				robot.keyPress(KeyEvent.VK_NUMPAD8);
				break;
			case "down":
				robot.keyPress(KeyEvent.VK_NUMPAD2);
				break;
			case "left":
				robot.keyPress(KeyEvent.VK_NUMPAD4);
				break;
			case "right":
				robot.keyPress(KeyEvent.VK_NUMPAD6);
				break;
			case "a":
				robot.keyPress(KeyEvent.VK_NUMPAD7);
				break;
			case "b":
				robot.keyPress(KeyEvent.VK_NUMPAD9);
				break;
			case "start":
				robot.keyPress(KeyEvent.VK_NUMPAD1);
				break;
			case "select":
				robot.keyPress(KeyEvent.VK_NUMPAD3);
				break;
			}
			
		}
	}
}
