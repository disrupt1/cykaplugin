package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cyka.GUIs.ManagePlayerGUI;

public class ManagePlayer implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (sender instanceof Player) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Use: /manage <player>");
                return true;
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) == null) {
                    player.sendMessage(ChatColor.RED + "Invalid player.");
                    return true;
                }
            } else {
                player.sendMessage(ChatColor.RED + "Use: /manage <player>");
                return true;
            }
        } else {
            System.out.println("Only a player can run this command.");
        }
        Player target = Bukkit.getPlayer(args[0]);
        new ManagePlayerGUI(player, target);
        return true;
    }

}