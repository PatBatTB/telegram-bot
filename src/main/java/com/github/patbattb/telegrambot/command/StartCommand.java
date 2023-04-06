package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Start {@link Command}
 */
public class StartCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public final static String MESSAGE = "✋ Hi. You run START command.";

    public StartCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId(), MESSAGE);
    }
}
