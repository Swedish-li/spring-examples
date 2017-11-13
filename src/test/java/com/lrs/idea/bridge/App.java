package com.lrs.idea.bridge;

// shift + f9 调试
// shift + f10 运行

public class App {
    public static void main(String[] args) {
        Sword sword = new Sword(new SoulEatingEnchantment());
        sword.wield();
        sword.swing();
        sword.unwield();

        Hammer hammer = new Hammer(new FlyingEnchantment());
        hammer.wield();
        hammer.swing();
        hammer.unwield();


    }
}
