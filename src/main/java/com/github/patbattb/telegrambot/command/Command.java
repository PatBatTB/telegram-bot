package com.github.patbattb.telegrambot.command;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Command interface for handling bot-commands.
 */
public interface Command {

    /**
     * The main method that will be called on receipt of any command
     * @param update provided {@link Update} object with all data for command.
     */
    void execute(Update update);
}
