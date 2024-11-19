package org.cyka.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class PlayerTracker implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player player) {
            if (args.length == 0) {
                player.sendMessage(ChatColor.RED + "Use: /Track <player>");
                return true;
            } else if (args.length == 1) {
                Player huntedPlayer = Bukkit.getPlayer(args[0]);
                if (huntedPlayer == null) {
                    player.sendMessage(ChatColor.RED + "Player not found.");
                    return true;
                } else {
                    if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
                        player.setCompassTarget(huntedPlayer.getLocation());
                        player.sendMessage(ChatColor.GREEN + "Now tracking " + huntedPlayer.getDisplayName() + ChatColor.GREEN + ".");
                        huntedPlayer.sendMessage(ChatColor.RED + "Someone knows your location...");
                        while (true) {
                            try {
                                Thread.sleep(250);
                                player.setCompassTarget(huntedPlayer.getLocation());
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    } else {
                        player.sendMessage(ChatColor.RED + "Please hold a compass in your hand.");
                        return true;
                    }
                }
            } else {
                player.sendMessage(ChatColor.RED + "Use: /Track <player>");
                return true;
            }
        } else {
            System.out.println("This command can only be run by a player.");
        }

        return true;
    }

}
