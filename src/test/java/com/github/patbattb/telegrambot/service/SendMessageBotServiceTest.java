package com.github.patbattb.telegrambot.service;

import com.github.patbattb.telegrambot.components.TelegramBot;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@ExtendWith(MockitoExtension.class)
class SendMessageBotServiceTest {


    @Mock
    private TelegramBot tgBot;

    @InjectMocks
    private SendMessageBotService sendMessageBotService;

    @Test
    @DisplayName("Check sending message")
    void shouldCorrectIdAndTextInMessage() throws TelegramApiException {
        Long chatId = 123456789L;
        String message = "test_message";

        SendMessage testSendMessage = new SendMessage();
        testSendMessage.setText(message);
        testSendMessage.setChatId(chatId);
        testSendMessage.enableHtml(true);

        sendMessageBotService.sendMessage(chatId, message);

        Mockito.verify(tgBot).execute(testSendMessage);
    }
}