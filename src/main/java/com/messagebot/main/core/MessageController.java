package com.messagebot.main.core;

import com.messagebot.main.consts.TelegramBotConsts;
import com.messagebot.main.handlers.UpdateHandlerImpl;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.TelegramBotAdapter;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/")
public class MessageController {

	private TelegramBot bot = TelegramBotAdapter.build(TelegramBotConsts.BOT_API_KEY);

	private UpdateHandlerImpl updateHandler = new UpdateHandlerImpl();

	@RequestMapping(value = "/callback/", method = RequestMethod.POST)
	public SendMessage sendMessage(@RequestBody Update update) {
		return updateHandler.update(update);
	}
}
