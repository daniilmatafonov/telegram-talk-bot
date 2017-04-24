package com.messagebot.main.bot;

import com.messagebot.main.commands.HelpCommand;
import com.messagebot.main.commands.HelloCommand;
import com.messagebot.main.consts.TelegramBotConsts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.exceptions.TelegramApiException;

/**
 * Created by dmatafonov on 18.04.2017.
 */
public class CommandsBot extends TelegramLongPollingCommandBot {

	Logger log = LoggerFactory.getLogger(CommandsBot.class);

	public CommandsBot() {
		HelpCommand helpCommand = new HelpCommand(this);
		register(new HelloCommand());
		register(helpCommand);
		registerDefaultAction((absSender, message) -> {
			SendMessage unknownCommand = new SendMessage();
			unknownCommand.setChatId(message.getChatId());
			unknownCommand.setText("Command " + " is not supported");
				try {
					sendMessage(unknownCommand);
				} catch (TelegramApiException e) {
					log.error(e.getMessage());
				}
		});
	}


	@Override
	public void processNonCommandUpdate(Update update) {
		SendMessage message = new SendMessage().setChatId(update.getMessage().getChatId()).setText("Hello, " + update.getMessage().getFrom().getFirstName() + " " + update.getMessage().getFrom().getLastName());
		try {
			sendMessage(message);
			log.info(message.getText());
		} catch (TelegramApiException e) {
			log.error(e.getMessage());
		}
	}

	@Override
	public String getBotUsername() {
		return TelegramBotConsts.BOT_NAME;
	}

	@Override
	public String getBotToken() {
		return TelegramBotConsts.BOT_API_KEY;
	}
}
