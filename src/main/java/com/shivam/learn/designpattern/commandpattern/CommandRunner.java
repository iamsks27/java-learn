package com.shivam.learn.designpattern.commandpattern;

import com.shivam.learn.designpattern.commandpattern.command.Command;
import com.shivam.learn.designpattern.commandpattern.executors.CommandExecutor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class CommandRunner {

    private final List<CommandExecutor> commandExecutors;

    public String runCommand(Command command) {
        for (final CommandExecutor commandExecutor : commandExecutors) {
            if (commandExecutor.isApplicable(command)) {
                return commandExecutor.execute(command);
            }
        }
        return "Invalid Command";
    }

}
