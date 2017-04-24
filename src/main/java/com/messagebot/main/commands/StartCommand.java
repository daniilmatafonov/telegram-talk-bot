package com.messagebot.main.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.repository.query.parser.Part;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Chat;
import org.telegram.telegrambots.api.objects.User;
import org.telegram.telegrambots.bots.AbsSender;
import org.telegram.telegrambots.bots.commands.BotCommand;
import org.telegram.telegrambots.bots.commands.ICommandRegistry;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by dmatafonov on 24.04.2017.
 */
public class StartCommand extends BotCommand {

	Logger log = LoggerFactory.getLogger(StartCommand.class);

	private ICommandRegistry commandRegistry;

	public StartCommand(ICommandRegistry commandRegistry){
		super("start","start dialog with bot");
		this.commandRegistry = commandRegistry;
	}


	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] args) {
		String userName = chat.getUserName();
		if (userName == null || userName.isEmpty()) {
			userName = user.getFirstName() + " " + user.getLastName();
		}
		StringBuilder messageTextBuilder = new StringBuilder("Hello, " + userName + ". Welcome to SimpleTalkBot. Let's start conversation.").append(" Commands which i can do ");
		for(BotCommand botCommand : commandRegistry.getRegisteredCommands()){
			messageTextBuilder.append("/" + botCommand.getCommandIdentifier() + " ");
		}
		SendMessage startMessage = new SendMessage();
		startMessage.setChatId(chat.getId().toString());
		startMessage.setText(messageTextBuilder.toString());
		try {
			absSender.sendMessage(startMessage);
		} catch (TelegramApiException e) {
				log.error(e.getMessage());
		}
	}
}
