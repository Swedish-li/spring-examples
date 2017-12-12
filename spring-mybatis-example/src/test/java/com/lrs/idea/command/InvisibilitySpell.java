package com.lrs.idea.command;

/**
 * concrete command
 *
 * @author
 * @create 2017-11-14 11:07
 **/

public class InvisibilitySpell extends Command {

    private Taget taget;

    @Override
    public void execute(Taget taget) {
        taget.setVisbility(Visbility.INVISIABLE);
        this.taget = taget;
    }

    @Override
    public void undo() {
        if (taget != null) {
            taget.setVisbility(Visbility.VISIABLE);
        }
    }

    @Override
    public void redo() {
        if (taget != null) {
            taget.setVisbility(Visbility.INVISIABLE);
        }
    }

    @Override
    public String toString() {
        return "invisibility";
    }
}
