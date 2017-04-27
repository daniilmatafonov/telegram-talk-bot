package com.messagebot.main.bot;

import com.messagebot.main.consts.TelegramBotConsts;
import com.messagebot.main.model.RequestType;
import org.apache.http.client.methods.HttpGet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * Created by dmatafonov on 02.05.2017.
 */
public class MessageRequest {

	private static Logger logger = LoggerFactory.getLogger(MessageRequest.class);

	public static HttpGet sendHelloMessageCommandRequest(int chat_id, String userName) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/" + RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Hello, " + userName + ". Welcome to SimpleTalkBot.", "UTF-8"));
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendGoodbyeMessageCommandRequest(int chat_id, String userName) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/" + RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("GoodBye, " + userName, "UTF-8"));
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendHelpMessageCommandRequest(int chat_id) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder("https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/" + RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Available commands are " + TelegramBotConsts.HELLO_COMMAND + " " + " " + TelegramBotConsts.LOCATION_COMMAND + " "  + TelegramBotConsts.HELP_COMMAND + " " +
				TelegramBotConsts.START_COMMAND + " " + TelegramBotConsts.STOP_COMMAND, "UTF-8"));
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendHelloKeyboard(int chat_id, String userName) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/"+ RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Hello, " + userName + ". Welcome to SimpleTalkBot.", "UTF-8"));
		sendMessage.append("&reply_markup=").append(URLEncoder.encode("{\"keyboard\":[[\"" + TelegramBotConsts.HELLO_KEYBOARD + "\",\"" + TelegramBotConsts.LOCATION_KEYBOARD +
				"\",\"" + TelegramBotConsts.HELP_KEYBOARD  + "\"],[\"" + TelegramBotConsts.START_KEYBOARD + "\",\"" + TelegramBotConsts.STOP_KEYBOARD  + "\"]],\"resize_keyboard\":true}", "UTF-8"));
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendHelpKeyboard(int chat_id) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/" + RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Available commands are " + TelegramBotConsts.HELLO_COMMAND + " " + " " + TelegramBotConsts.LOCATION_COMMAND + " " + TelegramBotConsts.HELP_COMMAND + " " +
				TelegramBotConsts.START_COMMAND + " " + TelegramBotConsts.STOP_COMMAND, "UTF-8"));
		sendMessage.append("&reply_markup=").append(URLEncoder.encode("{\"keyboard\":[[\"" + TelegramBotConsts.HELLO_KEYBOARD + "\",\"" + TelegramBotConsts.LOCATION_KEYBOARD +
				"\",\"" + TelegramBotConsts.HELP_KEYBOARD  + "\"],[\"" + TelegramBotConsts.START_KEYBOARD + "\",\"" + TelegramBotConsts.STOP_KEYBOARD  + "\"]],\"resize_keyboard\":true}", "UTF-8"));
		logger.info(sendMessage.toString());
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}
	public static HttpGet sendStopKeyboard(int chat_id, String userName) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/"+ RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Good bye, " + userName, "UTF-8"));
		sendMessage.append("&reply_markup=").append(URLEncoder.encode("{\"keyboard\":[[\"" + TelegramBotConsts.HELLO_KEYBOARD + "\",\"" + TelegramBotConsts.LOCATION_KEYBOARD +
				"\",\"" + TelegramBotConsts.HELP_KEYBOARD  + "\"],[\"" + TelegramBotConsts.START_KEYBOARD + "\",\"" + TelegramBotConsts.STOP_KEYBOARD  + "\"]],\"resize_keyboard\":true}", "UTF-8"));
		logger.info(sendMessage.toString());
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendStartKeyboard(int chat_id) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/"+ RequestType.sendMessage.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&text=").append(URLEncoder.encode("Let's start conversation", "UTF-8"));
		sendMessage.append("&reply_markup=").append(URLEncoder.encode("{\"keyboard\":[[\"" + TelegramBotConsts.HELLO_KEYBOARD + "\",\"" + TelegramBotConsts.LOCATION_KEYBOARD +
				"\",\"" + TelegramBotConsts.HELP_KEYBOARD  + "\"],[\"" + TelegramBotConsts.START_KEYBOARD + "\",\"" + TelegramBotConsts.STOP_KEYBOARD  + "\"]],\"resize_keyboard\":true}", "UTF-8"));
		logger.info(sendMessage.toString());
		HttpGet sendMessageRequest = new HttpGet(sendMessage.toString());
		return sendMessageRequest;
	}

	public static HttpGet sendLocation(int chat_id) throws UnsupportedEncodingException {
		final StringBuilder sendMessage = new StringBuilder(
				"https://api.telegram.org/bot" + TelegramBotConsts.BOT_API_KEY + "/" + RequestType.sendLocation.name());
		sendMessage.append("?chat_id=").append(chat_id);
		sendMessage.append("&latitude=").append(URLEncoder.encode("55.7522" , "UTF-8"));
		sendMessage.append("&longitude=").append(URLEncoder.encode("37.6156", "UTF-8"));
		sendMessage.append("&reply_markup=").append(URLEncoder.encode("{\"keyboard\":[[\"" + TelegramBotConsts.HELLO_KEYBOARD + "\",\"" + TelegramBotConsts.LOCATION_KEYBOARD +
				"\",\"" + TelegramBotConsts.HELP_KEYBOARD  + "\"],[\"" + TelegramBotConsts.START_KEYBOARD + "\",\"" + TelegramBotConsts.STOP_KEYBOARD  + "\"]],\"resize_keyboard\":true}", "UTF-8"));
		logger.info(sendMessage.toString());
		HttpGet sendLocationRequest = new HttpGet(sendMessage.toString());
		return sendLocationRequest;
	}

}

