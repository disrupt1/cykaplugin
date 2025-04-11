package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PlayerPing implements CommandExecutor {

    public boolean onCommand(CommandSender sender,  Command command, String s, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                int ping = player.getPing();
                player.sendMessage(ChatColor.GREEN + "Your ping is: " + ChatColor.YELLOW + ping + "ms");
                return true;
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                int tping = target.getPing();
                player.sendMessage(ChatColor.YELLOW + target.getDisplayName() + "'s " + ChatColor.GREEN + "ping is: " + ChatColor.YELLOW + tping + "ms");
                return true;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Only a player can run this command");
            System.out.println("Only a player can run this command");
            return true;
        }
        return true;
    }
}
