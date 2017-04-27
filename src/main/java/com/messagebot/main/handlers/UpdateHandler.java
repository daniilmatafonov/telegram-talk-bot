package com.messagebot.main.handlers;

import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

/**
 * Created by dmatafonov on 27.04.2017.
 */
public interface UpdateHandler {
	SendMessage update(Update update);
}
