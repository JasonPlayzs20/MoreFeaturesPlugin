package com.jasonplayzs20.morefeatures.Enchantments;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class SlashEnchant implements TabCompleter, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        return false;
    }
    @Override
    public List<String> onTabComplete(CommandSender commandSender, Command command, String s, String[] strings) {
        List<String> enchantmentsList = new ArrayList<>();
        enchantmentsList.add("Fast Attack");
        enchantmentsList.add("Wither Blade");
        return enchantmentsList;
    }


}
