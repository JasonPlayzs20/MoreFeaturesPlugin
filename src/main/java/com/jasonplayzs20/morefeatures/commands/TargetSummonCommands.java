package com.jasonplayzs20.morefeatures.commands;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

public class TargetSummonCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        Player player = (Player) commandSender;
        Location playerLocation = player.getLocation();
        LivingEntity zombifiedPigman = (LivingEntity) player.getWorld().spawnEntity(playerLocation, EntityType.ZOMBIFIED_PIGLIN);
        zombifiedPigman.setCustomName("KIRK");
        zombifiedPigman.setGlowing(true);
        zombifiedPigman.setSilent(true);
        zombifiedPigman.setAI(false);
        if (Objects.equals(strings[0], "a")) {
            zombifiedPigman.setAI(true);
        }
        player.sendMessage("code1");
        if (Objects.equals(strings[0], "p")) {
            player.sendMessage("hey");
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1000000, 20, false, false);
            player.sendMessage("potion");
            zombifiedPigman.addPotionEffect(potionEffect);
            player.sendMessage("apply");
        }
        else if (Objects.equals(strings[0], "ap")) {
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE,1000000,20,false,false);
            zombifiedPigman.addPotionEffect(potionEffect);
            zombifiedPigman.setAI(true);
        }

        return false;
    }
}
