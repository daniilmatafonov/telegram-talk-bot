package com.messagebot.main;


import com.messagebot.main.bot.BotInitiator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

@SpringBootApplication
public class TelegramTalkBotApplication {

	public static void main(String[] args) throws TelegramApiRequestException {
		SpringApplication.run(TelegramTalkBotApplication.class, args);
		BotInitiator.initializeMyBot();
	}
}
