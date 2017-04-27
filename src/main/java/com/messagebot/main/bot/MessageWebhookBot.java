package com.messagebot.main.bot;

import com.messagebot.main.consts.TelegramBotConsts;
import org.telegram.telegrambots.api.methods.BotApiMethod;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramWebhookBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.generics.WebhookBot;

/**
 * Created by dmatafonov on 26.04.2017.
 */
public class MessageWebhookBot extends TelegramWebhookBot{

	@Override
	public BotApiMethod onWebhookUpdateReceived(Update update) {
		if(update.hasMessage() && update.getMessage().hasText()){
			SendMessage sendMessage = new SendMessage();
			sendMessage.setChatId(update.getMessage().getChatId());
			sendMessage.setText(update.getMessage().getText());
			try {
				sendMessage(sendMessage);
				return sendMessage;
			} catch (TelegramApiException e) {
				e.printStackTrace();
			}
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
		return "";
	}



}
