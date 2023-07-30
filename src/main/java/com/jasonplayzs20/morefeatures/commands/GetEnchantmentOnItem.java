package com.jasonplayzs20.morefeatures.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collection;

public class GetEnchantmentOnItem implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) return false;
        Player player = (Player) commandSender;
        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
        player.sendMessage();
        player.sendMessage(itemMeta.getEnchants().toString());
        return false;
    }
}
