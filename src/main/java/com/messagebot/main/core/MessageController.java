package com.messagebot.main.core;

import com.messagebot.main.bot.MessageRequest;
import com.messagebot.main.consts.TelegramBotConsts;
import com.messagebot.main.model.Message;
import com.messagebot.main.model.Update;
import com.messagebot.main.utils.Utils;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
@RequestMapping(name = "/")
public class MessageController {

	private HttpGet sendMessageRequest;
	private Logger logger = LoggerFactory.getLogger(MessageController.class);

	@RequestMapping(value = "/callback/", method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	public void sendMessage(@RequestBody Update update) throws Exception {
		Message message = update.getMessage();
		logger.info(message.getText());
		logger.info(String.valueOf(message.getChat().getId()));
		if (message.hasText() && !Utils.getUserName(message).isEmpty()) {
			String command = message.getText();
			int chat_id = message.getChat().getId();
			getBotAnswer(chat_id, Utils.getUserName(message), command);
		}
	}

	private void getBotAnswer(int chat_id, String userName, String command) throws IOException {
		HttpClient httpClient = HttpClientBuilder.create().build();
		switch (command) {
			case TelegramBotConsts.HELLO_COMMAND:
				sendMessageRequest = MessageRequest.sendHelloMessageCommandRequest(chat_id, userName);
				break;
			case TelegramBotConsts.STOP_COMMAND:
				sendMessageRequest = MessageRequest.sendGoodbyeMessageCommandRequest(chat_id, userName);
				break;
			case TelegramBotConsts.START_COMMAND:
				sendMessageRequest = MessageRequest.sendStartKeyboard(chat_id);
				break;
			case TelegramBotConsts.HELP_COMMAND:
				sendMessageRequest = MessageRequest.sendHelpMessageCommandRequest(chat_id);
				break;
			case TelegramBotConsts.LOCATION_COMMAND:
				sendMessageRequest = MessageRequest.sendLocation(chat_id);
				break;
			case TelegramBotConsts.HELLO_KEYBOARD:
				sendMessageRequest = MessageRequest.sendHelloKeyboard(chat_id, userName);
				break;
			case TelegramBotConsts.HELP_KEYBOARD:
				sendMessageRequest = MessageRequest.sendHelpKeyboard(chat_id);
				break;
			case TelegramBotConsts.START_KEYBOARD:
				sendMessageRequest = MessageRequest.sendStartKeyboard(chat_id);
				break;
			case TelegramBotConsts.STOP_KEYBOARD:
				sendMessageRequest = MessageRequest.sendStopKeyboard(chat_id, userName);
				break;
			case TelegramBotConsts.LOCATION_KEYBOARD:
				sendMessageRequest = MessageRequest.sendLocation(chat_id);
				break;
		}
		logger.info(sendMessageRequest.toString());
		httpClient.execute(sendMessageRequest);
	}
}

