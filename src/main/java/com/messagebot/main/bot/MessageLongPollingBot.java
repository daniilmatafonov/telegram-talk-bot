package com.messagebot.main.bot;

import com.messagebot.main.consts.BotCommandsConsts;
import com.messagebot.main.consts.TelegramBotConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dmatafonov on 25.04.2017.
 */
public class MessageLongPollingBot extends TelegramLongPollingBot {

	private Logger logger = LoggerFactory.getLogger(MessageLongPollingBot.class);

	@Override
	public void onUpdateReceived(Update update) {
		try {
			if (update.hasMessage()) {
				org.telegram.telegrambots.api.objects.Message message = update.getMessage();
				String command = message.getText();
				switch (command) {
					case TelegramBotConsts.HELLO_KEYBOARD:
						sendMessage(sendHello(message));
						break;
					case TelegramBotConsts.START_KEYBOARD:
						sendMessage(sendStart(message));
						break;
					case TelegramBotConsts.STOP_KEYBOARD:
						sendMessage(sendStop(message));
						break;
					case TelegramBotConsts.HELP_KEYBOARD:
						sendMessage(sendHelp(message));
						break;
					default:
						sendMessage(sendStart(message));
				}

			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	@Override
	public String getBotUsername() {
		return TelegramBotConsts.BOT_NAME;
	}

	@Override
	public String getBotToken() {
		return TelegramBotConsts.BOT_API_KEY;
	}

	private static ReplyKeyboardMarkup getMainMenuKeyboard() {
		ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
		replyKeyboardMarkup.setOneTimeKeyboad(false);
		replyKeyboardMarkup.setResizeKeyboard(true);
		replyKeyboardMarkup.setSelective(false);
		List<KeyboardRow> keyboardRowList = new ArrayList<>();
		KeyboardRow firstKeyBoardRow = new KeyboardRow();
		KeyboardRow secondKeyBoardRow = new KeyboardRow();
		firstKeyBoardRow.add(TelegramBotConsts.HELLO_KEYBOARD);
		firstKeyBoardRow.add(TelegramBotConsts.HELP_KEYBOARD);
		secondKeyBoardRow.add(TelegramBotConsts.START_KEYBOARD);
		secondKeyBoardRow.add(TelegramBotConsts.STOP_KEYBOARD);
		keyboardRowList.add(firstKeyBoardRow);
		keyboardRowList.add(secondKeyBoardRow);
		replyKeyboardMarkup.setKeyboard(keyboardRowList);
		return replyKeyboardMarkup;
	}


	private static SendMessage sendHello(org.telegram.telegrambots.api.objects.Message message) {
		String userName = BotUtils.getUserName(message);
		StringBuilder messageTextBuilder = new StringBuilder("Hello, ").append(userName);
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setReplyMarkup(getMainMenuKeyboard());
		sendMessage.setChatId(message.getChatId());
		sendMessage.setText(messageTextBuilder.toString());
		return sendMessage;
	}

	private static SendMessage sendStart(org.telegram.telegrambots.api.objects.Message message) {
		String userName = BotUtils.getUserName(message);
		StringBuilder messageTextBuilder = new StringBuilder("Hello, " + userName + ". Welcome to SimpleTalkBot. Let's start conversation.");
		SendMessage sendMessage = prepareSendRequest(message, messageTextBuilder);
		return sendMessage;
	}

	private static SendMessage sendStop(org.telegram.telegrambots.api.objects.Message message) throws TelegramApiException {
		String userName = BotUtils.getUserName(message);
		StringBuilder messageTextBuilder = new StringBuilder("Good bye, " + userName);
		SendMessage sendMessage = prepareSendRequest(message, messageTextBuilder);
		return sendMessage;
	}

	private static SendMessage sendHelp(org.telegram.telegrambots.api.objects.Message message) {
		StringBuilder res = new StringBuilder("Available commands are " + BotCommandsConsts.HELLO_COMMAND + " " + BotCommandsConsts.HELP_COMMAND + " "
				+ BotCommandsConsts.START_COMMAND + " " + BotCommandsConsts.STOP_COMMAND);
		SendMessage sendMessage = prepareSendRequest(message, res);
		return sendMessage;
	}

	private static SendMessage prepareSendRequest(Message message, StringBuilder messageBuilder) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setReplyMarkup(getMainMenuKeyboard());
		sendMessage.setChatId(message.getChatId());
		sendMessage.setText(messageBuilder.toString());
		return sendMessage;
	}

}
