package ru.tinkoff.edu.java.bot.configuration;

import jakarta.validation.constraints.NotNull;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.validation.annotation.Validated;
import ru.tinkoff.edu.java.bot.telegram.command.Command;
import ru.tinkoff.edu.java.bot.telegram.command.CommandList;
import ru.tinkoff.edu.java.bot.telegram.command.HelpCommand;
import ru.tinkoff.edu.java.bot.telegram.command.ListCommand;
import ru.tinkoff.edu.java.bot.telegram.command.StartCommand;
import ru.tinkoff.edu.java.bot.telegram.command.TrackCommand;
import ru.tinkoff.edu.java.bot.telegram.command.UntrackCommand;

import java.util.Arrays;
import java.util.List;

@Validated
@ConfigurationProperties(prefix = "bot", ignoreUnknownFields = false)
public record ApplicationConfig(
        @NotNull String test,
        @NotNull String username,
        @NotNull String token) {

    @Bean
    public List<Command> commandList() {
        return Arrays.asList(
                new StartCommand(CommandList.START),
                new HelpCommand(CommandList.HELP),
                new ListCommand(CommandList.LIST),
                new TrackCommand(CommandList.TRACK),
                new UntrackCommand(CommandList.UNTRACK));
    }
}
