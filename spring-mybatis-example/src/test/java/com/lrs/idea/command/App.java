package com.lrs.idea.command;

/**
 * 将请求封装到对象中，以参数化客户端和请求
 *
 * @author Swedis-li
 * @create 2017-11-14 11:37
 **/

public class App {
    public static void main(String[] args) {
        Wizard wizard = new Wizard();
        Gobin gobin = new Gobin();

        gobin.printStatus();

        wizard.castSpell(new ShrinkSpell(),gobin);
        gobin.printStatus();

        wizard.castSpell(new InvisibilitySpell(),gobin);
        gobin.printStatus();

        wizard.undoLastSpell();
        gobin.printStatus();

        wizard.undoLastSpell();
        gobin.printStatus();

        wizard.redoLastSpell();
        gobin.printStatus();

        wizard.redoLastSpell();
        gobin.printStatus();


    }
}
