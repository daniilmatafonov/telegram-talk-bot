package com.messagebot.main.service;


import com.messagebot.main.model.Message;
import com.messagebot.main.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public List<Message> findAll() {
		return messageRepository.findAll();
	}

	@Override
	public Message findMessageById(Long id) {
		return messageRepository.findOne(id);
	}
}
