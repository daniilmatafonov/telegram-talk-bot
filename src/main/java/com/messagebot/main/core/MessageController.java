package com.messagebot.main.core;

import com.messagebot.main.model.Message;
import com.messagebot.main.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@RequestMapping(value = "/messages/", method = RequestMethod.GET)
	public ResponseEntity<List<Message>> retriveAllMessages() {
		List<Message> messages = fillMessages();
		if (messages.isEmpty()) {
			return new ResponseEntity<List<Message>>(messages, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Message>>(messages, HttpStatus.OK);
	}

	@RequestMapping(value = "/message/{id}", method = RequestMethod.GET)
	public ResponseEntity<Message> retrieveMessageById(@PathVariable Long id) {
		Message message = searchMessageById(id);
		if (message == null) {
			return new ResponseEntity<Message>(message, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Message>(message, HttpStatus.OK);
	}


	private List<Message> fillMessages() {
		Message firstMessage = new Message();
		Message secondMessage = new Message();
		firstMessage.setText("test message");
		firstMessage.setId(24124214L);
		secondMessage.setId(21424215515L);
		secondMessage.setText("test message2");
		List<Message> messages = new ArrayList<>();
		messages.add(firstMessage);
		messages.add(secondMessage);
		return messages;
	}

	private Message searchMessageById(Long id) {
		List<Message> messages = fillMessages();
		for (Message message : messages) {
			if (message.getId().equals(id)) {
				return message;
			}
		}
		return null;
	}


}
