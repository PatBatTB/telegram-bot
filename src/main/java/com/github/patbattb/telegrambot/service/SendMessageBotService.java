package com.github.patbattb.telegrambot.service;

import com.github.patbattb.telegrambot.domain.TelegramBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Implementation of {@link SendMessageService} interface.
 * Service for sending messages.
 */
@Log4j2
@Service
public class SendMessageBotService implements SendMessageService {

    @Autowired
    private final TelegramBot bot;

    public SendMessageBotService(TelegramBot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(Long chatId, String message) {
        var sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            log.warn("Bot execute error: " + e.getMessage());
        }
    }
}
