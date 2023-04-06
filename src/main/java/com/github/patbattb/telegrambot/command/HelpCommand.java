package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Help {@link Command}
 */
public class HelpCommand implements Command {
    
    private final SendMessageBotService sendMessageBotService;
    
    public static final String MESSAGE = """
            <b>Available commands</b>
            
            %s - to run.
            %s - to exit.
            """
            .formatted(CommandName.START.getName(), CommandName.STOP.getName());

    public HelpCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId(), MESSAGE);
    }
}
