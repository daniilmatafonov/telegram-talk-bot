package com.messagebot.main.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by dmatafonov on 24.04.2017.
 */
public class HelloCommand extends BotCommand {

	Logger log = LoggerFactory.getLogger(HelloCommand.class);

	public HelloCommand(){
		super("hello","say hello to user");
	}


	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] args) {
		String firstName = user.getFirstName();
		String lastName = user.getLastName();
		StringBuilder messageTextBuilder = new StringBuilder("Hello, ").append(firstName).append(" ").append(lastName);
		if (args != null && args.length > 0) {
			for(String arg : args){
				if(arg.equalsIgnoreCase("-about")){
					messageTextBuilder.append("\n");
					messageTextBuilder.append("I am simpletalkbot\n");
				}
			}
		}

		SendMessage answer = new SendMessage();
		answer.setChatId(chat.getId().toString());
		answer.setText(messageTextBuilder.toString());

		try {
			absSender.sendMessage(answer);
		} catch (TelegramApiException e) {
			log.error(e.getMessage());
		}
	}
}
