package com.github.patbattb.telegrambot.components;

import com.github.patbattb.telegrambot.service.MessageHandler;
import com.github.patbattb.telegrambot.service.SendMessageBotService;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Main class for telegram bot.
 */
@Log4j2
public class TelegramBot extends TelegramLongPollingBot {

    private final String username;
    private final SendMessageBotService sendMessageBotService;
    private final MessageHandler messageHandler;


    public TelegramBot(String username, String token) {
        super(token);
        this.username = username;
        sendMessageBotService = new SendMessageBotService(this);
        messageHandler = new MessageHandler(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            messageHandler.processingUpdate(update);
        }
    }


    @Override
    public String getBotUsername() {
        return username;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public SendMessageBotService getSendMessageBotService() {
        return sendMessageBotService;
    }
}
