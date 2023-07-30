package com.jasonplayzs20.morefeatures.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareAnvilEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class AnvilListener implements Listener {

    @EventHandler
    public static void Anvil(PrepareAnvilEvent e) {
        ItemStack item1 = e.getInventory().getItem(0);
        ItemStack item2 = e.getInventory().getItem(1);
        ItemStack results = e.getResult();
        ItemMeta resultMeta;
        try {
            resultMeta = results.getItemMeta();
        } catch (Exception resultMeeta) {
            return;
        }
        ItemStack Enchanted;
        ItemStack NOTEnchanted;
        Player player = Bukkit.getPlayer("IamSorry_");
        if (!item1.getItemMeta().hasEnchants() && !item2.getItemMeta().hasEnchants()) return;

        if (item1.getItemMeta().hasEnchants() && !item2.getItemMeta().hasEnchants()) {
//            player.sendMessage("1 0");
            Enchanted = item1;

            Map<Enchantment,Integer> ench = Enchanted.getEnchantments();
            Set<Enchantment> enchantments = ench.keySet();
            Collection<Integer> levels = ench.values();
            for (int i = 0; i < ench.size();i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantments.toArray()[i])) {
                    resultMeta.addEnchant((Enchantment) enchantments.toArray()[i], (Integer) levels.toArray()[i],true);
                    results.setItemMeta(resultMeta);
                    e.setResult(results);
                }
            }
            results.setItemMeta(resultMeta);
            e.setResult(results);
            player.sendMessage(results.getEnchantments().toString());
//
        } else if (item2.getItemMeta().hasEnchants() && !item1.getItemMeta().hasEnchants()) {
//            player.sendMessage("0 1");
            Enchanted = item2;

            Map<Enchantment,Integer> ench = Enchanted.getEnchantments();
            Set<Enchantment> enchantments = ench.keySet();
            Collection<Integer> levels = ench.values();
            for (int i = 0; i < ench.size();i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantments.toArray()[i])) {
                    resultMeta.addEnchant((Enchantment) enchantments.toArray()[i], (Integer) levels.toArray()[i],true);
                    results.setItemMeta(resultMeta);
                    e.setResult(results);
                }
            }
            results.setItemMeta(resultMeta);
            e.setResult(results);
            player.sendMessage(results.getEnchantments().toString());
//            e.getView().setItem(2,results);
        } else {
//            player.sendMessage("1 1");
            //loop both and stuff
            Map<Enchantment,Integer> ench1 = item1.getEnchantments();
            Map<Enchantment,Integer> ench2 = item2.getEnchantments();
            Set<Enchantment> enchantment1 = ench1.keySet();
            Collection<Integer> levels1 =  ench1.values();
            Set<Enchantment> enchantment2 = ench2.keySet();
            Collection<Integer> levels2 =  ench2.values();
            for (int i = 0; i < ench1.size(); i++) {
//                player.sendMessage("here");
                if (!resultMeta.hasEnchant((Enchantment) enchantment1.toArray()[i])) {
                    player.sendMessage(enchantment1.toArray()[i].toString()+levels1.toArray()[i]);
                    resultMeta.addEnchant((Enchantment) enchantment1.toArray()[i], (Integer) levels1.toArray()[i],true);
                    player.sendMessage(resultMeta.getEnchants().toString());
                    results.setItemMeta(resultMeta);
                    e.setResult(results);
                }
            }
            for (int i = 0; i < ench2.size(); i++) {
//                player.sendMessage("here");
//                player.sendMessage("vugyihuo");
                if (!resultMeta.hasEnchant((Enchantment) enchantment2.toArray()[i])) {
                    player.sendMessage(enchantment2.toArray()[i].toString()+levels2.toArray()[i]);
                    resultMeta.addEnchant((Enchantment) enchantment2.toArray()[i], (Integer) levels2.toArray()[i],true);
                    player.sendMessage(resultMeta.getEnchants().toString());
                    results.setItemMeta(resultMeta);
                    e.setResult(results);
                }
            }

            results.setItemMeta(resultMeta);
            e.getInventory().setItem(2,results);
            e.setResult(results);
        }
    }
}
