package com.shivam.learn.designpattern.commandpattern.executors;

import com.shivam.learn.designpattern.commandpattern.command.Command;
import com.shivam.learn.designpattern.commandpattern.command.Database;

public class BalanceCommandExecutor extends CommandExecutor {

    private static final String BALANCE = "balance";

    public BalanceCommandExecutor(Database database) {
        super(database);
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(BALANCE);
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 1;
    }

    @Override
    protected String executeCommand(Command command) {
        final String user = command.getParams().get(0);
        return String.valueOf(this.database.getUserBalance(user));
    }
}
