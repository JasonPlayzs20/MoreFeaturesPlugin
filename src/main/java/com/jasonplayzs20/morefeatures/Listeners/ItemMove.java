package com.jasonplayzs20.morefeatures.Listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import static com.jasonplayzs20.morefeatures.Enchantments.FastEnchantment.setNormalSpeed;

public class ItemMove implements Listener {

    @EventHandler
    public static void itemScroling(PlayerInteractEvent e) {
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
        if (!e.getPlayer().getInventory().getItemInMainHand().getItemMeta().hasEnchant(Enchantment.getByKey(NamespacedKey.minecraft("fast_attack")))) {
            e.getPlayer().sendMessage("normal");
            setNormalSpeed(e.getPlayer());

        }else {
            e.getPlayer().getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(5+1.4);
        }
    }
}
