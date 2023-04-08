package com.github.patbattb.telegrambot.service;
import com.github.patbattb.telegrambot.command.CommandMap;
import com.github.patbattb.telegrambot.components.TelegramBot;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Service for handling incoming messages from {@link TelegramBot}
 */
@Log4j2
public class MessageHandler {

    private final TelegramBot telegramBot;
    private final SendMessageBotService sendMessageBotService;
    private final CommandMap commandMap;

    public MessageHandler(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
        sendMessageBotService = telegramBot.getSendMessageBotService();
        commandMap = new CommandMap(sendMessageBotService);
    }

    public void processingUpdate(Update update) {
        String commandName = update.getMessage().getText().toLowerCase().trim();
        commandMap.getCommand(commandName).execute(update);
    }
}
