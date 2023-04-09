package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Info {@link Command}
 */
public class InfoCommand implements Command {

    private final SendMessageBotService sendMessageBotService;
    public static final String MESSAGE = "Info message";

    public InfoCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }
    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId(), MESSAGE);
    }
}
