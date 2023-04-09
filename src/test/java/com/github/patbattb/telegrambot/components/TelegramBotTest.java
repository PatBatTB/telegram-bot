package com.github.patbattb.telegrambot.components;

import com.github.patbattb.telegrambot.service.MessageHandler;
import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@ExtendWith(MockitoExtension.class)
class TelegramBotTest {

    private TelegramBot telegramBot;
    final String username = "username";
    final private String token = "token";

    @Mock
    Update update;
    @Mock
    Message message;
    @Mock
    MessageHandler messageHandler;
    @Mock
    SendMessageBotService sendMessageBotService;

    @BeforeEach
    void setUp() {
        telegramBot = new TelegramBot(username, token);
        try {
            FieldUtils.writeField(telegramBot, "messageHandler", messageHandler, true);
            FieldUtils.writeField(telegramBot, "sendMessageBotService", sendMessageBotService, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    @DisplayName("Checks onUpdateReceived when update has message and has text.")
    void shouldOnUpdateReceivedCallsProcessingUpdateWithCorrectDataInUpdate() {
        Mockito.when(update.hasMessage()).thenReturn(true);
        Mockito.when(update.getMessage()).thenReturn(message);
        Mockito.when(message.hasText()).thenReturn(true);
        try {
            FieldUtils.writeField(telegramBot, "messageHandler", messageHandler, true);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        telegramBot.onUpdateReceived(update);
        Mockito.verify(messageHandler).processingUpdate(update);
    }

    @Test
    @DisplayName("Checks onUpdateReceived when update has no message")
    void shouldOnUpdateReceivedNoActionWithEmptyMessageOnUpdate() {
        Mockito.when(update.hasMessage()).thenReturn(false);
        telegramBot.onUpdateReceived(update);
        Mockito.verify(messageHandler, Mockito.times(0)).processingUpdate(update);
    }

    @Test
    @DisplayName("Checks returning value of getBotUsername()")
    void shouldGetBotUsernameReturnsUsername() {
        Assertions.assertThat(telegramBot.getBotUsername()).isEqualTo(username);
    }

    @Test
    @DisplayName("Checks returning value of getMessageHandler()")
    void shouldGetMessageHandlerReturnsValueOfMessageHanlderFiled() {
        Assertions.assertThat(telegramBot.getMessageHandler()).isEqualTo(messageHandler);
    }

    @Test
    @DisplayName("Checks returning value of getSendMessageBotService()")
    void shouldGetSendMessageBotServiceReturnsValueOfsendMessageBotServiceFiled() {
        Assertions.assertThat(telegramBot.getSendMessageBotService()).isEqualTo(sendMessageBotService);
    }
}