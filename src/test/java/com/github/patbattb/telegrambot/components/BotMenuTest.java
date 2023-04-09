package com.github.patbattb.telegrambot.components;

import com.github.patbattb.telegrambot.command.CommandName;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

class BotMenuTest {

    private BotMenu menu;

    @BeforeEach
    void setUp() {
        menu = new BotMenu();

    }

    @DisplayName("Check all commands in CommandName enum contains in BotMenu")
    @Test
    void ShouldBotMenuContainsAllCommands() {
        for (CommandName commandName : CommandName.values()) {
            BotCommand botCommand = new BotCommand(commandName.getName(), commandName.getDescription());
            Assertions.assertThat(menu.getListOfCommands().contains(botCommand)).isEqualTo(true);
        }
    }
}