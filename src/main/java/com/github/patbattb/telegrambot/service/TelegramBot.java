package com.github.patbattb.telegrambot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {

    private final String username;

    public TelegramBot(
            @Value("${bot.username}") String username,
            @Value("${bot.token}") String token,
            TelegramBotsApi telegramBotsApi)
            throws TelegramApiException
    {
        super(token);
        this.username = username;
        telegramBotsApi.registerBot(this);
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText().trim();
            long chatId = update.getMessage().getChatId();

            sendMessage(chatId, message);

        }
    }

    @Override
    public String getBotUsername() {
        return username;
    }

    private void sendMessage(long chatId, String message) {
        var sm = new SendMessage();
        sm.setChatId(chatId);
        sm.setText(message);

        try {
            execute(sm);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
