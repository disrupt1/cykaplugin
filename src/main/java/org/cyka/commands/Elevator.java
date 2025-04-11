package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyka.GUIs.ElevatorGUI;

public class Elevator implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (sender instanceof Player player) {
            Player target = Bukkit.getPlayer(args[0]);
            if (args.length == 1) {
                if (target == null) {
                    player.sendMessage(ChatColor.RED + "Player not found.");
                    return true;
                } else {
                    new ElevatorGUI(player, target);
                }
            } else {
                player.sendMessage(ChatColor.RED + "Usage: /elevator <player>");
                return true;
            }
        } else {
            System.out.println("Only a player can run this command.");
            return true;
        }
        return true;
    }

}
