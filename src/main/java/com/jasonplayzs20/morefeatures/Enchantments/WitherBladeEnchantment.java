package com.jasonplayzs20.morefeatures.Enchantments;

import com.jasonplayzs20.morefeatures.MoreFeatures;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

public class WitherBladeEnchantment extends Enchantment implements Listener {

    private final MoreFeatures plugin;// reference to main class
    public WitherBladeEnchantment(MoreFeatures plugin) {
        super(NamespacedKey.minecraft("wither_blade"));
        this.plugin = MoreFeatures.getMainInstance();
    }

    @EventHandler
    public static void onAttack(EntityDamageByEntityEvent e) {
        if (!(e.getDamager() instanceof Player)) {
            return;
        }
        Player player = (Player) e.getDamager();

    }

    @Override
    public String getName() {
        return "Wither Blade";
    }

    @Override
    public int getMaxLevel() {
        return 4;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }
}
