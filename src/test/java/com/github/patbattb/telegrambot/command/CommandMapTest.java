package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

@ExtendWith(MockitoExtension.class)
class CommandMapTest {

    @Mock
    private SendMessageBotService sendMessageBotService;
    @Mock
    private Update update;
    @Mock
    private Message message;

    @InjectMocks
    private CommandMap commandMap;

    @Test
    @DisplayName("Check map to contain all existing commands")
    void shouldGetAllExistingCommand() {
        for (CommandName name : CommandName.values()) {
            Command testCommand = commandMap.getCommand(name.getName());
            Assertions.assertThat(testCommand.getClass())
                    .isNotEqualTo(UnknownCommand.class);
        }
    }

    @Test
    @DisplayName("Check map to contain unknown command")
    void shouldGetUnknownCommand() {
        String fakeCommand = "fdgfdhgfghsddfsg";
        Command testCommand = commandMap.getCommand(fakeCommand);
        Assertions.assertThat(testCommand.getClass())
                .isEqualTo(UnknownCommand.class);
    }

    @Test
    @DisplayName("Check all commands execute methods")
    void shouldEveryCommandSendRightMessage() throws NoSuchFieldException, IllegalAccessException {
        long fakeChatId = 123L;

        for (CommandName name : CommandName.values()) {
            Command testCommand = commandMap.getCommand(name.getName());
            Mockito.when(message.getChatId()).thenReturn(fakeChatId);
            Mockito.when(update.getMessage()).thenReturn(message);
            String commandMessage = testCommand.getClass().getField("MESSAGE").get(testCommand).toString();
            testCommand.execute(update);
            Mockito.verify(sendMessageBotService, Mockito.times(1))
                    .sendMessage(123L, commandMessage);
        }
    }
}