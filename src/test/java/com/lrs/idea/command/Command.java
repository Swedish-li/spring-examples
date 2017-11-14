package com.lrs.idea.command;

/**
 * command interface
 *
 * @author
 * @create 2017-11-14 11:04
 **/

public abstract class Command {

    abstract void execute(Taget taget);

    abstract void undo();

    abstract void redo();

    @Override
    public abstract String toString();
}
