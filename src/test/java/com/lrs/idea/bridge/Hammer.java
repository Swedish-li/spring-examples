package com.lrs.idea.bridge;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hammer implements Weapon{

    private final static Logger logger = LoggerFactory.getLogger(Hammer.class);

    private final Enchantment enchantment;

    public Hammer(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    @Override
    public void wield() {
        logger.info("The hammer is widlded!");
        enchantment.onActivate();
    }

    @Override
    public void swing() {
        logger.info("the hammer is swinged");
        enchantment.apply();
    }

    @Override
    public void unwield() {
        logger.info("the hammer is unwielded!");
        enchantment.onDeactivate();
    }

    @Override
    public Enchantment getEnchantment() {
        return enchantment;
    }
}
