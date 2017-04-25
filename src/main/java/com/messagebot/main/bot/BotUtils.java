package com.messagebot.main.bot;

import org.telegram.telegrambots.api.objects.Message;

/**
 * Created by dmatafonov on 25.04.2017.
 */
public class BotUtils {

	public static String getUserName(Message message){
		return message.getFrom().getFirstName() + " " + message.getFrom().getLastName();
	}
}
