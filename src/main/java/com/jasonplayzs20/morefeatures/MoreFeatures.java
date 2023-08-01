package com.jasonplayzs20.morefeatures;

import com.jasonplayzs20.morefeatures.Enchantments.FastEnchantment;
import com.jasonplayzs20.morefeatures.Enchantments.WitherBladeEnchantment;
import com.jasonplayzs20.morefeatures.Listeners.AnvilListener;
import com.jasonplayzs20.morefeatures.Listeners.ItemMove;
import com.jasonplayzs20.morefeatures.commands.GetEnchantmentOnItem;
import com.jasonplayzs20.morefeatures.commands.TargetSummonCommands;
import com.jasonplayzs20.morefeatures.commands.boost;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;

public final class MoreFeatures extends JavaPlugin {

    private static MoreFeatures mainInstance;

    public static MoreFeatures getMainInstance() {
        return mainInstance;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        mainInstance = this;

        FastEnchantment fastEnchantment = new FastEnchantment(mainInstance);
        WitherBladeEnchantment witherBladeEnchantment = new WitherBladeEnchantment();
        this.getCommand("boost").setExecutor(new boost(fastEnchantment.getKey()));
        this.getCommand("getEnchants").setExecutor(new GetEnchantmentOnItem());
        this.getCommand("summonDummy").setExecutor(new TargetSummonCommands());
        Bukkit.getPluginManager().registerEvents(new FastEnchantment(mainInstance),this);
        getServer().getPluginManager().registerEvents(new AnvilListener(), this);
        getServer().getPluginManager().registerEvents(new ItemMove(), this);
        registerEnchantment(fastEnchantment);
        registerEnchantment(witherBladeEnchantment);
        System.out.println("1");

    }
    private void registerEnchantment(Enchantment enchantment) {
        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);
            Enchantment.registerEnchantment(enchantment);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
