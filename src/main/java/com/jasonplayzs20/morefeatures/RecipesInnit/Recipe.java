package com.jasonplayzs20.morefeatures.RecipesInnit;

import com.jasonplayzs20.morefeatures.MoreFeatures;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;

public class Recipe {
    private final MoreFeatures plugin;// reference to main class

    public Recipe(MoreFeatures plugin) {
        this.plugin = plugin;
    }


    public static void addRecipes(NamespacedKey key, ItemStack itemStack, String string1, String string2, String string3, Material material1, Material material2, Material material3) {
        ShapedRecipe shapedRecipe = new ShapedRecipe(key, itemStack);
        shapedRecipe.shape(string1, string2, string3);
        shapedRecipe.setIngredient('A', material1);
        shapedRecipe.setIngredient('B', material2);
        shapedRecipe.setIngredient('C', material3);
        Bukkit.addRecipe(shapedRecipe);
    }

}
