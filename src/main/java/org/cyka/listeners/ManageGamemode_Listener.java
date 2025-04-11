package org.cyka.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ManageGamemode_Listener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Player target = Bukkit.getPlayer(e.getInventory().getItem(22).getItemMeta().getDisplayName());

        if (e.getView().getTitle().equals(ChatColor.RED + "Manage Gamemode")) {
            e.setCancelled(true);
        }
        if (e.getCurrentItem() == null) {
            return;
        }
        if (target == null) {
            player.closeInventory();
            player.sendMessage(ChatColor.RED + "The target is not online.");
        }

        if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Creative")) {
            player.closeInventory();
            try {
                target.setGameMode(GameMode.CREATIVE);
                target.sendMessage(ChatColor.YELLOW + "An operator has changed your game mode to Creative Mode.");
                player.sendMessage(ChatColor.GREEN + "The target player is now in Creative Mode.");
            } catch (Exception err) {
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "An error occurred.");
                err.printStackTrace();
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Survival")) {
            player.closeInventory();
            try {
                target.setGameMode(GameMode.SURVIVAL);
                target.sendMessage(ChatColor.YELLOW + "An operator has changed your game mode to Survival Mode.");
                player.sendMessage(ChatColor.GREEN + "The target player is now in Survival Mode.");
            } catch (Exception err) {
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "An error occurred.");
                err.printStackTrace();
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.WHITE + "Adventure")) {
            player.closeInventory();
            try {
                target.setGameMode(GameMode.ADVENTURE);
                target.sendMessage(ChatColor.YELLOW + "An operator has changed your game mode to Adventure Mode.");
                player.sendMessage(ChatColor.GREEN + "The target player is now in Adventure Mode.");
            } catch (Exception err) {
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "An error occurred.");
                err.printStackTrace();
            }
        } else if (e.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GRAY + "Spectator")) {
            player.closeInventory();
            try {
                target.setGameMode(GameMode.SPECTATOR);
                target.sendMessage(ChatColor.YELLOW + "An operator has changed your game mode to Spectator Mode.");
                player.sendMessage(ChatColor.GREEN + "The target player is now in Spectator Mode.");
            } catch (Exception err) {
                player.closeInventory();
                player.sendMessage(ChatColor.RED + "An error occurred.");
                err.printStackTrace();
            }
        }
    }
}
