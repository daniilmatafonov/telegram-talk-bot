package com.messagebot.main;


import com.messagebot.main.bot.InitializePollingBot;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.exceptions.TelegramApiException;

@SpringBootApplication
public class TelegramTalkBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(TelegramTalkBotApplication.class, args);
		InitializePollingBot.init();
	}
}
