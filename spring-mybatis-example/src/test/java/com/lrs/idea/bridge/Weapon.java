package com.lrs.idea.bridge;

/**
 * 使用组合的方式进行扩展
 */
public interface Weapon {
    void wield();
    void swing();
    void unwield();

    Enchantment getEnchantment();

}

