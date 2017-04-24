package com.messagebot.main.commands;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class HelpCommand extends BotCommand {

	Logger log = LoggerFactory.getLogger(HelpCommand.class);

	private ICommandRegistry commandRegistry;

	public HelpCommand(ICommandRegistry registry) {
		super("help", "Bot list commands");
		this.commandRegistry = registry;
	}


	@Override
	public void execute(AbsSender absSender, User user, Chat chat, String[] args) {
		StringBuilder res = new StringBuilder("Available commands are ");
		for(BotCommand botCommand : commandRegistry.getRegisteredCommands()){
			res.append("/" + botCommand.getCommandIdentifier() + " ");
		}
		SendMessage sendMessage = new SendMessage();
		sendMessage.setChatId(chat.getId());
		sendMessage.setText(res.toString());
		try {
			absSender.sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			log.error(e.getMessage());
		}

	}
}
