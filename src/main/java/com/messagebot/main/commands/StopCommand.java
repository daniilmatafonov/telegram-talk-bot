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
public class StopCommand extends BotCommand {

	Logger logger = LoggerFactory.getLogger(StopCommand.class);

	public StopCommand(){
		super("stop", "stop the bot");
	}


	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
		String userName = user.getUserName();
		if(userName == null || userName.isEmpty()){
			userName = user.getFirstName() + " " + user.getLastName();
		}
		SendMessage stopBot = new SendMessage();
		stopBot.setChatId(chat.getId());
		stopBot.setText("Good bye, " + userName);
		try {
			absSender.sendMessage(stopBot);
		} catch (TelegramApiException e) {
			logger.error(e.getMessage());
		}
	}
}
