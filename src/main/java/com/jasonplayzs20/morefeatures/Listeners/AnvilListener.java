package com.jasonplayzs20.morefeatures.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentWrapper;
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
        Player player = Bukkit.getPlayer("IamSorry_");
        ItemStack item1 = e.getInventory().getItem(0);
        ItemStack item2 = e.getInventory().getItem(1);
        ItemStack results;
        if (e.getInventory().getItem(2) != null) {
            results = e.getResult();
        } else {
            results = new ItemStack(item1);
        }
        ItemMeta resultMeta;
        try {
            resultMeta = results.getItemMeta();
        } catch (Exception resultMeeta) {
            return;
        }
        ItemStack Enchanted;
        ItemStack NOTEnchanted;

        if (!item1.getItemMeta().hasEnchants() && !item2.getItemMeta().hasEnchants()) return;
        if (item1.getItemMeta().hasEnchants() && !item2.getItemMeta().hasEnchants()) {
            Enchanted = item1;

            Map<Enchantment, Integer> ench = Enchanted.getEnchantments();
            Set<Enchantment> enchantments = ench.keySet();
            Collection<Integer> levels = ench.values();
            for (int i = 0; i < ench.size(); i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantments.toArray()[i])) {
                    resultMeta.addEnchant((Enchantment) enchantments.toArray()[i], (Integer) levels.toArray()[i], true);
                }
            }

        } else if (item2.getItemMeta().hasEnchants() && !item1.getItemMeta().hasEnchants()) {
            Enchanted = item2;

            Map<Enchantment, Integer> ench = Enchanted.getEnchantments();
            Set<Enchantment> enchantments = ench.keySet();
            Collection<Integer> levels = ench.values();
            for (int i = 0; i < ench.size(); i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantments.toArray()[i])) {
                    resultMeta.addEnchant((Enchantment) enchantments.toArray()[i], (Integer) levels.toArray()[i], true);
                }
            }
        } else {
            Map<Enchantment, Integer> ench1 = item1.getEnchantments();
            Map<Enchantment, Integer> ench2 = item2.getEnchantments();
            Set<Enchantment> enchantment1 = ench1.keySet();
            Collection<Integer> levels1 = ench1.values();
            Set<Enchantment> enchantment2 = ench2.keySet();
            Collection<Integer> levels2 = ench2.values();
            for (int i = 0; i < ench1.size(); i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantment1.toArray()[i])) {
//                    player.sendMessage(enchantment1.toArray()[i].toString() + levels1.toArray()[i]);
                    resultMeta.addEnchant((Enchantment) enchantment1.toArray()[i], (Integer) levels1.toArray()[i], true);
//                    player.sendMessage(resultMeta.getEnchants().toString());
                }
            }
            for (int i = 0; i < ench2.size(); i++) {
                if (!resultMeta.hasEnchant((Enchantment) enchantment2.toArray()[i])) {
//                    player.sendMessage(enchantment2.toArray()[i].toString() + levels2.toArray()[i]);
                    resultMeta.addEnchant((Enchantment) enchantment2.toArray()[i], (Integer) levels2.toArray()[i], true);
//                    player.sendMessage(resultMeta.getEnchants().toString());
                }
            }

        }
        player.sendMessage("getting lore");
        List<String> item1Lore = item1.getItemMeta().getLore();
        List<String> item2Lore = item2.getItemMeta().getLore();
        List resultLore = resultMeta.getLore();
        for (String lore : item1Lore) {
            player.sendMessage("lore" + lore);
            if (item2Lore == null) {break;}
            else if (item2Lore.contains(lore)){

                int enchantmentLevel = Integer.parseInt(lore.substring(lore.length()-1));
                player.sendMessage("got it");
                player.sendMessage(Integer.toString(enchantmentLevel));
                String key = lore.substring(2,lore.length()-2).toLowerCase().replace(' ','_');
                String name = lore.substring(0,lore.length()-2);
                player.sendMessage("got name" + key);

                Enchantment enchantment = Enchantment.getByKey(NamespacedKey.minecraft(key));
                player.sendMessage("enchantment"+enchantment.toString());
                if (enchantmentLevel+1 <= enchantment.getMaxLevel()) {
                    resultMeta.removeEnchant(enchantment);
                    resultMeta.addEnchant(enchantment, enchantmentLevel + 1, true);
                    resultLore.remove(lore);
                    resultLore.add(name + " " + (enchantmentLevel + 1));
                }
                resultMeta.setLore(resultLore);
            }
        }

//            player.sendMessage("got lore");
        player.sendMessage("resultLore" + resultLore);



        results.setItemMeta(resultMeta);
        ItemStack itemStack = new ItemStack(results);
        e.setResult(itemStack);
        e.getInventory().setItem(2,itemStack);

        player.sendMessage("first" + item1.toString());
        player.sendMessage("Second" + item2.toString());
        player.sendMessage("Result" + results.toString());
    }
}
