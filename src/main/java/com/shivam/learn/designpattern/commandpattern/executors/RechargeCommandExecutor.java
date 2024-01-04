package com.shivam.learn.designpattern.commandpattern.executors;

import com.shivam.learn.designpattern.commandpattern.command.Command;
import com.shivam.learn.designpattern.commandpattern.command.Database;
import com.shivam.learn.designpattern.commandpattern.command.RechargeProvider;

public class RechargeCommandExecutor extends CommandExecutor {

    private static final String RECHARGE = "recharge";

    private final RechargeProvider rechargeProvider;

    public RechargeCommandExecutor(Database database, RechargeProvider rechargeProvider) {
        super(database);
        this.rechargeProvider = rechargeProvider;
    }

    @Override
    public boolean isApplicable(Command command) {
        return command.getName().equals(RECHARGE);
    }

    @Override
    protected boolean isValid(Command command) {
        return command.getParams().size() == 2;
    }

    @Override
    protected String executeCommand(Command command) {
        final String user = command.getParams().get(0);
        final int rechargeAmount = Integer.parseInt(command.getParams().get(1));
        final int userBalance = this.database.getUserBalance(user);
        if (userBalance < rechargeAmount) {
            return "Not sufficient balance";
        }
        this.rechargeProvider.recharge(user, rechargeAmount);
        return "Recharge Done";
    }
}
