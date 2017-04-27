package com.messagebot.main.handlers;

import com.messagebot.main.consts.TelegramBotConsts;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Created by dmatafonov on 27.04.2017.
 */
public class UpdateHandlerImpl implements UpdateHandler {


	private TelegramBot telegramBot;

	public UpdateHandlerImpl(){
		telegramBot = TelegramBotAdapter.build(TelegramBotConsts.BOT_API_KEY);
	}

	@Override
	public SendMessage update(Update update) {
		Long chatId = 25L;
		String text = "/hello";

			if (text.startsWith("/hello")) {
					SendMessage sendMessage = new SendMessage(chatId, text);
					telegramBot.execute(sendMessage);
					return sendMessage;
			}
			return null;

	}
}
