package com.github.patbattb.telegrambot.command;

import com.github.patbattb.telegrambot.service.SendMessageBotService;
import com.google.common.collect.ImmutableMap;

/**
 * Service for handling bot commands
 */
public class CommandMap {

    private final ImmutableMap<String, Command> map;
    private final Command unknownCommand;

    public CommandMap (SendMessageBotService sendMessageBotService) {
        map = ImmutableMap.<String, Command>builder()
                .put(CommandName.START.getName(), new StartCommand(sendMessageBotService))
                .put(CommandName.STOP.getName(), new StopCommand(sendMessageBotService))
                .put(CommandName.HELP.getName(), new HelpCommand(sendMessageBotService))
                .build();
        unknownCommand = new UnknownCommand(sendMessageBotService);
    }

    public Command getCommand(String commandName) {
        return map.getOrDefault(commandName, unknownCommand);
    }
}
