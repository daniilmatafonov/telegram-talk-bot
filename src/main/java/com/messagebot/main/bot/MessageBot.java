package com.messagebot.main.bot;

import com.messagebot.main.consts.TelegramBotConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by dmatafonov on 18.04.2017.
 */
public class MessageBot extends TelegramLongPollingBot {

	Logger log = LoggerFactory.getLogger(MessageBot.class);

	@Override
	public void onUpdateReceived(Update update) {
		if (update.hasMessage() && update.getMessage().hasText() && !update.getMessage().getFrom().getFirstName().isEmpty() && !update.getMessage().getFrom().getLastName().isEmpty()) {
			SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText("Hello, " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
			try {
				sendMessage(message);
			} catch (TelegramApiException e) {
				log.error(e.getMessage());
			}
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
}
