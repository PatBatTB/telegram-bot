package com.github.patbattb.telegrambot.domain;

import com.github.patbattb.telegrambot.command.CommandMap;
import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Telegram Bot with username and token from application.properties
 */
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final String username;
    private final CommandMap commandMap;

    public TelegramBot(@Value("${bot.token}") String token,
             @Value("${bot.username}") String username)
    {
        super(token);
        this.username = username;
        this.commandMap = new CommandMap(new SendMessageBotService(this));
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            commandMap.getCommand(message).execute(update);
        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

}
