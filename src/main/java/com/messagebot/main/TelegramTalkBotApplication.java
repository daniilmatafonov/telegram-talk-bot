package com.messagebot.main;


import com.messagebot.main.bot.MessageLongPollingBot;
import com.messagebot.main.bot.MessageWebhookBot;
import com.messagebot.main.consts.TelegramBotConsts;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegramTalkBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(TelegramTalkBotApplication.class, args);
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		//telegramBotsApi = createWebHookBot();
		//telegramBotsApi.registerBot(new MessageWebhookBot());
		telegramBotsApi.registerBot(new MessageLongPollingBot());
	}


	private static MessageLongPollingBot createPollingTelegramBotsApi() throws TelegramApiException {
		return new MessageLongPollingBot();
	}


	private static TelegramBotsApi createWebHookBot() throws TelegramApiException {
		return new TelegramBotsApi(TelegramBotConsts.EXTERNALWEBHOOKURL, TelegramBotConsts.INTERNALWEBHOOKURL);
	}


}
