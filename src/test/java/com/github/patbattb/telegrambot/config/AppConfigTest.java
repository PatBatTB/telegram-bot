package com.github.patbattb.telegrambot.config;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@ExtendWith(MockitoExtension.class)
class AppConfigTest {

    @Mock
    DefaultBotSession botSession;
    TelegramBotsApi telegramBotsApi;

    @Test
    @DisplayName("Check constructor with correct parameter")
    void shouldTelegramBotsApiReturnCorrectlyInstance() throws TelegramApiException {
        telegramBotsApi = new TelegramBotsApi(botSession.getClass());
        Assertions.assertThat(telegramBotsApi).isNotNull();
    }

    @Test
    @DisplayName("Check constructor with null parameter")
    void shouldTelegramBotsApiConstructorTrowsException() {
        Assertions.assertThatThrownBy(() -> new TelegramBotsApi(null))
                .isInstanceOf(TelegramApiException.class);
    }

}