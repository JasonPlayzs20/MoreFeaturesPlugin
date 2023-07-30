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

//        if (result.getType().name().toLowerCase().contains("sword")) {
//            addAttrubute(result,Attribute.GENERIC_ATTACK_SPEED,"generic.attackSpeed", -2.6d);
//            switch (result.getType().name().toLowerCase()) {
//                case "wooden_sword":
//                    dmg = attackDamages.Wood_Sword-1;
//                    break;
//                case "stone_sword":
//                    dmg = attackDamages.Stone_Sword-1;
//                    break;
//                case "iron_sword":
//                    dmg = attackDamages.Iron_Sword-1;
//                    break;
//                case "golden_sword":
//                    dmg = attackDamages.Gold_Sword-1;
//                    break;
//                case "diamond_sword":
//                    dmg = attackDamages.Diamond_Swrod-1;
//                    break;
//                case "netherite_sword":
//                    dmg = attackDamages.Netherite_Sword-1;
//                    break;
//                default:
//                    break;
//            }
//        } else if (result.toString().toLowerCase().contains("axe")) {
//            switch (result.getType().name().toLowerCase()) {
//                case "wooden_axe":
//                    dmg = attackDamages.Wood_Axe;
//                    break;
//                case "stone_axe":
//                    dmg = attackDamages.Stone_Axe;
//                    break;
//                case "iron_axe":
//                    dmg = attackDamages.Iron_Axe;
//                    break;
//                case "golden_axe":
//                    dmg = attackDamages.Gold_Axe;
//                    break;
//                case "diamond_axe":
//                    dmg = attackDamages.Diamond_Axe;
//                    break;
//                case "netherite_axe":
//                    dmg = attackDamages.Netherite_Axe;
//                    break;
//                default:
//                    break;
//            }
//        }
        player.sendMessage(String.valueOf(dmg));
        player.getInventory().getItemInMainHand().addUnsafeEnchantment(Enchantment.getByKey(key), 1);
        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();

//        AttributeModifier attributeModifier3 = attribute("generic.attackDamage", dmg);
//        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, attributeModifier3);
        List list = itemMeta.getLore();
        if (list != null) {
            itemMeta.setLore(Arrays.asList(list + (ChatColor.GRAY + "Fast Attack")));
        } else {
            itemMeta.setLore(Arrays.asList((ChatColor.GRAY + "Fast Attack")));
        }
        player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
        player.sendMessage("added enchant");
        return false;
    }
}
