package com.github.patbattb.telegrambot.service;

import com.github.patbattb.telegrambot.components.TelegramBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Service for registration {@link TelegramBot}
 */
@Log4j2
@Service
public final class BotRegistrationService {

    @Autowired
    private TelegramBot telegramBot;

    @Autowired
    private TelegramBotsApi telegramBotsApi;

    @EventListener({ContextRefreshedEvent.class})
    public void init() {
        try {
            telegramBotsApi.registerBot(telegramBot);
        } catch (TelegramApiException e) {
            log.error("Register bot Error: " + e.getMessage());
        }
    }
}
