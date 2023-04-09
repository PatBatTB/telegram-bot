package com.github.patbattb.telegrambot.service;

import com.github.patbattb.telegrambot.components.TelegramBot;
import lombok.extern.log4j.Log4j2;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendMessageService} interface.
 * Service for sending messages.
 */
@Log4j2
public class SendMessageBotService implements SendMessageService {

    private final TelegramBot telegramBot;

    public SendMessageBotService(TelegramBot telegramBot) {
        this.telegramBot = telegramBot;
    }
    
    @Override
    public void sendMessage(Long chatId, String message) {

        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);
        try {
            telegramBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error sending message: " + e.getMessage());
        }
    }
}
