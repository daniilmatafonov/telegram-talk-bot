package com.messagebot.main;


import com.messagebot.main.bot.MessageBot;
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
		telegramBotsApi.registerBot(new MessageBot());
		//	telegramBotsApi.registerBot(new CommandsBot());
	}


}
