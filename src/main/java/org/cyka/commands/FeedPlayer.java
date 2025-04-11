package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedPlayer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player p) {
            Player target = Bukkit.getPlayer(args[0]);
            if (args.length == 0) {
                p.setFoodLevel(20);
                p.sendMessage(ChatColor.GREEN + "Your food level is now maxed out.");
                return true;
            } else if (args.length == 1) {
                if (target == null) {
                    p.sendMessage(ChatColor.RED + "Player not found.");
                } else {
                    target.setFoodLevel(20);
                    target.sendMessage(ChatColor.GREEN + "An operator set your food level to full.");
                    p.sendMessage(ChatColor.YELLOW + "The target's food level is now maxed out.");
                    return true;
                }
            } else {
                p.sendMessage(ChatColor.RED + "Use: /feed Or /feed <player>");
                return true;
            }
        } else {
            System.out.println("Only players can execute this command.");
        }
        return true;
    }

}
