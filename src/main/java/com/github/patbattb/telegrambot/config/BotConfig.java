package com.github.patbattb.telegrambot.config;

import com.github.patbattb.telegrambot.components.BotMenu;
import com.github.patbattb.telegrambot.components.TelegramBot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.api.methods.commands.SetMyCommands;
import org.telegram.telegrambots.meta.api.objects.commands.scope.BotCommandScopeDefault;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

/**
 * Initialization and configuration {@link TelegramBot} bean
 */
@Log4j2
@Configuration
public class BotConfig {

    @Value("${bot.username}")
    private String username;

    @Value("${bot.token}")
    private String token;

    @Bean
    TelegramBot telegramBot() {
        var telegramBot =  new TelegramBot(username, token);

        try {
            telegramBot.execute(new SetMyCommands(botMenu().getListOfCommands(),
                    new BotCommandScopeDefault(),
                    null));
        } catch (TelegramApiException e) {
            log.error("Error setting command list: " + e.getMessage());
        }

        return telegramBot;
    }

    @Bean
    BotMenu botMenu() {
        return new BotMenu();
    }
}
