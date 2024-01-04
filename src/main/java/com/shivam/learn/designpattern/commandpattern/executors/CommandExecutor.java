package com.shivam.learn.designpattern.commandpattern.executors;

import com.shivam.learn.designpattern.commandpattern.command.Command;
import com.shivam.learn.designpattern.commandpattern.command.Database;

public abstract class CommandExecutor {

    protected Database database;

    public CommandExecutor(Database database) {
        this.database = database;
    }

    public String execute(Command command) {
        if (!isValid(command)) {
            return "Invalid Command";
        }
        return executeCommand(command);
    }

    public abstract boolean isApplicable(Command command);

    protected abstract boolean isValid(Command command);

    protected abstract String executeCommand(Command command);
}
