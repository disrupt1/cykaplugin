package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealPlayer implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.setHealth(20);
                player.sendMessage(ChatColor.GREEN + "You have been healed.");
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Player not found.");
                    return true;
                } else {
                    target.setHealth(20);
                    target.sendMessage(ChatColor.GREEN + "You have been healed.");
                    player.sendMessage(ChatColor.GREEN + "Target player has been healed");
                }
            } else {
                player.sendMessage(ChatColor.RED + "Use: /heal or /heal <player>");
            }
        } else {
            System.out.println("Only a player can run this command");
        }
        return true;
    }
}
