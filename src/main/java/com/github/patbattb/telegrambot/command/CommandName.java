package com.github.patbattb.telegrambot.command;

/**
 * Enumeration of available bots commands for {@link CommandMap};
 */
public enum CommandName {

    START("/start"),
    STOP("/stop"),
    HELP("/help");

    private final String name;

    CommandName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
