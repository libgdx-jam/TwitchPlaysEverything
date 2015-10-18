package co.porkopolis.tpe.model.irctest;

public class Main {
	public static void main(String[] args) throws Exception {
		TwitchBot bot = new TwitchBot();
		bot.setVerbose(true);
		bot.connect("irc.twitch.tv", 6667, "oauth:6kl7e8tg2x6khrpx6mizmzewt8hr8h");
		bot.joinChannel("#TwitchCanPlayIt".toLowerCase());
	}
}
