package com.jasonplayzs20.morefeatures.RecipesInnit;

import com.jasonplayzs20.morefeatures.MoreFeatures;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.UUID;

public class ItemStackIn {
    private final MoreFeatures plugin;// reference to main class


    public ItemStackIn(MoreFeatures plugin) {
        this.plugin = plugin;
    }

    public static ItemStack createNewItem(Material material, String name, String... lore) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(name);
        itemMeta.setLore(Arrays.asList(lore));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static ItemStack addEnchantment(ItemStack itemStack, Enchantment enchantments, int level) {
        itemStack.addUnsafeEnchantment(enchantments,level);
        return itemStack;
    }

    public static ItemStack addAttrubute(ItemStack itemStack, Attribute attribute, String attributeText, double attack) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.addAttributeModifier(attribute, new AttributeModifier(UUID.randomUUID(),attributeText, attack, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    public static AttributeModifier attribute(String attributeText, double attack) {
        AttributeModifier attribute1 = new AttributeModifier(UUID.randomUUID(),attributeText, attack, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        return attribute1;
    }
}
