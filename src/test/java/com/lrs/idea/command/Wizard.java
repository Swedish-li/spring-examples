package com.lrs.idea.command;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Deque;
import java.util.LinkedList;

/**
 * invoker of commands
 *
 * @author Swedish-li
 * @create 2017-11-14 11:22
 **/

public class Wizard {
    private static final Logger LOGGER = LoggerFactory.getLogger(Wizard.class);

    private Deque<Command> undoStack = new LinkedList<>();
    private Deque<Command> redoStack = new LinkedList<>();

    public Wizard() {

    }

    public void  castSpell(Command command,Taget taget){
        LOGGER.info("{},casts {} at {}",this,command,taget);
        command.execute(taget);
        undoStack.addLast(command);
    }

    public void undoLastSpell(){
        if (!undoStack.isEmpty()){
            Command previous = undoStack.pollLast();
            redoStack.offerLast(previous);
            LOGGER.info("{} undoes {}",this,previous);
            previous.undo();
        }
    }
    
    public void redoLastSpell(){
        if (!redoStack.isEmpty()){
            Command previous = redoStack.pollLast();
            undoStack.offerLast(previous);
            LOGGER.info("{} redoes {}",this,previous);
            previous.redo();
        }
    }
    

    @Override
    public String toString() {
        return "Wizard";
    }
}
