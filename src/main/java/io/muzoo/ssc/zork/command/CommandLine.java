package io.muzoo.ssc.zork.command;

public class CommandLine {
    private CommandType commandType;

    public CommandType getCommandType() {
        return commandType;
    }

    public String getArgument() {
        return argument;
    }

    private String argument;

    public CommandLine(CommandType commandType, String argument) {
        this.commandType = commandType;
        this.argument = argument;
    }
}
