package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Unknown {@link Command}
 *
 */
public class UnknownCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String MESSAGE = "Unknown command, please send \"/help\" to get the list of available commands";

    public UnknownCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId(), MESSAGE);
    }
}
