package com.jasonplayzs20.morefeatures.commands;

import com.google.common.collect.Multimap;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

import static com.jasonplayzs20.morefeatures.RecipesInnit.ItemStackIn.addAttrubute;
import static com.jasonplayzs20.morefeatures.RecipesInnit.ItemStackIn.attribute;

import com.jasonplayzs20.morefeatures.AttackDamages;

public class boost implements CommandExecutor {

    private NamespacedKey key;

    public boost(NamespacedKey key) {
        this.key = key;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        double dmg = 1;
        player.sendMessage("hiejo");
        ItemStack result = player.getInventory().getItemInMainHand();
        AttackDamages attackDamages = new AttackDamages();

        player.sendMessage(String.valueOf(dmg));
        player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.getByKey(key), 1);
        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();

        List list = itemMeta.getLore();
        if (list != null) {
            itemMeta.setLore(Arrays.asList(list + (ChatColor.GRAY + "Fast Attack 1")));
        } else {
            itemMeta.setLore(Arrays.asList((ChatColor.GRAY + "Fast Attack 1")));
        }
        player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
        player.sendMessage("added enchant");
        return false;
    }
}
