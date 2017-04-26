package com.messagebot.main.core;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.api.methods.send.SendMessage;

@RestController
@RequestMapping(name = "/")
public class MessageController {


	@RequestMapping(value = "/callback/", method = RequestMethod.GET)
	public ResponseEntity<SendMessage> sendMessage() {
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId("1425215");
		sendMessage.setText("Hello");
		return new ResponseEntity<>(sendMessage, HttpStatus.OK);
	}


}
