package com.github.patbattb.telegrambot.command;

/**
 * Enumeration of available bots commands for {@link CommandMap};
 */
public enum CommandName {

    START("/start", "Start command"),
    STOP("/stop", "Stop command" ),
    INFO("/info", "Info command"),
    HELP("/help", "Help command");

    private final String name;
    private final String description;

    CommandName(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }
}
