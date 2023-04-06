package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Stop {@link Command}
 */
public class StopCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String MESSAGE = "You run STOP command, bye. ✋";

    public StopCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId(), MESSAGE);
    }
}
