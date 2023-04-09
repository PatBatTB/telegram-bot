package com.github.patbattb.telegrambot.command;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;


class CommandNameTest {

    CommandName name = CommandName.START;

    @DisplayName("Test getter of name field")
    @Test
    void shouldGetNameReturnsCorrectValue() {
        Assertions.assertThat(name.getName()).isEqualTo("/start");
    }

    @DisplayName("Test getter of description field")
    @Test
    void shouldGetDesriptionMethodReturnsValueOfDescriptionFiled() {
        Field field;
        String descriptionValue;
        try {
            field = name.getClass().getDeclaredField("description");
            field.setAccessible(true);
            descriptionValue = (String) field.get(name);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Assertions.assertThat(name.getDescription()).isEqualTo(descriptionValue);
    }
}