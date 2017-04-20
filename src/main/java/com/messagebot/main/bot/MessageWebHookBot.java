package com.messagebot.main.bot;

import com.messagebot.main.consts.TelegramBotConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramWebhookBot;

/**
 * Created by dmatafonov on 19.04.2017.
 */
public class MessageWebHookBot extends TelegramWebhookBot {

	Logger log = LoggerFactory.getLogger(MessageWebHookBot.class);


	@Override
	public BotApiMethod onWebhookUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText()) {
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText("Hello, " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
			return message;
		}
		return null;
	}

	@Override
	public String getBotUsername() {
		return TelegramBotConsts.BOT_NAME;
	}

	@Override
	public String getBotToken() {
		return TelegramBotConsts.BOT_API_KEY;
	}

	@Override
	public String getBotPath() {
		return TelegramBotConsts.BOT_PATH;
	}
}
