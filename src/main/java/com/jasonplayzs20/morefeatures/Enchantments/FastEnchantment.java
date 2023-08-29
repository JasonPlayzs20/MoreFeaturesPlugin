package com.jasonplayzs20.morefeatures.Enchantments;

import com.jasonplayzs20.morefeatures.MoreFeatures;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import static com.jasonplayzs20.morefeatures.RecipesInnit.ItemStackIn.attribute;

public class FastEnchantment extends Enchantment implements Listener {

    private final MoreFeatures plugin;// reference to main class
    public FastEnchantment(MoreFeatures mainInstance) {
        super(NamespacedKey.minecraft("fast_attack"));
        this.plugin = MoreFeatures.getMainInstance();
    }
    public static void setNormalSpeed(Player player) {
        player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(2.6+1.4);
    }

    public static void setNormalAttackDamage(Player player) {
        player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getDefaultValue());
    }

    @EventHandler
    public void onAttack(EntityDamageByEntityEvent e) {

        if (e.getDamager().getType() == EntityType.PLAYER) {

            Player player = (Player) e.getDamager();
            if (player.getInventory().getItemInMainHand() == null) {
                return;
            }
            if (!player.getInventory().getItemInMainHand().getItemMeta().hasEnchant(this)) {
                player.sendMessage("normal speed from ench");
                setNormalSpeed(player);
                return;
            }
            ItemStack item = player.getInventory().getItemInMainHand();
            int enchantment = item.getItemMeta().getEnchantLevel(getByKey(this.getKey()));
            Bukkit.getScheduler().cancelTasks(plugin);
            Bukkit.getScheduler().runTaskLaterAsynchronously(plugin, (Runnable) () -> {
                setNormalSpeed(player);
                setNormalAttackDamage(player);
                player.sendMessage(ChatColor.GREEN+"Your Speed Attack Has Wore Off");
            },100);
            player.sendMessage(String.valueOf(e.getDamage()));
            if (enchantment == 1) {
                player.sendMessage(String.valueOf(player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).getDefaultValue()));
                player.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(0);
                player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(5+1.4);

            } else if (enchantment == 2) {
                player.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(9+1.4);
                setNormalAttackDamage(player);
            }
        }
    }


    @Override
    public String getName() {
        return "Fast Attack";
    }

    @Override
    public int getMaxLevel() {
        return 2;
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
        return true;
    }
}
