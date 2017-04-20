package com.messagebot.main.bot;

import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

/**
 * Created by dmatafonov on 20.04.2017.
 */
public class InitializePollingBot {
	public static void init() throws TelegramApiRequestException {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		telegramBotsApi.registerBot(new MessagePollingBot());
	}
}
