package com.github.patbattb.telegrambot.components;

import com.github.patbattb.telegrambot.command.CommandName;
import com.google.common.collect.ImmutableList;
import org.telegram.telegrambots.meta.api.objects.commands.BotCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Menu of command for {@link TelegramBot}
 */
public class BotMenu {

    private final ImmutableList<BotCommand> listOfCommands;

    public BotMenu() {
        List<BotCommand> tempList = new ArrayList<>();
        for (CommandName command : CommandName.values()) {
            tempList.add(new BotCommand(command.getName(), command.getDescription()));
        }
        listOfCommands = ImmutableList.copyOf(tempList);
    }

    public ImmutableList<BotCommand> getListOfCommands() {
        return listOfCommands;
    }
}
