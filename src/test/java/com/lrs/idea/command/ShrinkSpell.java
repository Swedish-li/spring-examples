package com.lrs.idea.command;

/**
 * concrete command
 *
 * @author
 * @create 2017-11-14 11:17
 **/

public class ShrinkSpell extends Command {

    private Size oldSize;

    private Taget taget;

    @Override
    void execute(Taget taget) {
        oldSize = taget.getSize();
        taget.setSize(Size.SMALL);
        this.taget = taget;
    }

    @Override
    void undo() {
        if (oldSize != null && taget != null) {
            Size temp = taget.getSize();
            taget.setSize(oldSize);
            oldSize = temp;
        }
    }

    @Override
    void redo() {
        undo();
    }

    @Override
    public String toString() {
        return "Shrink spell";
    }
}
