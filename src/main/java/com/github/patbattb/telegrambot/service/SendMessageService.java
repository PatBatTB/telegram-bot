package com.github.patbattb.telegrambot.service;

/**
 * Service for sending messages from bot.
 */
public interface SendMessageService {

    /**
     * Method for sending message.
     * @param chatId receiver ID
     * @param message Text message
     */
    void sendMessage(Long chatId, String message);
}
