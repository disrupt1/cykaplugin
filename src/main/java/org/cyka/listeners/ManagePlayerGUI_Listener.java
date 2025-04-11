package org.cyka.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.cyka.GUIs.ManageGamemodeGUI;

import java.util.Objects;

public class ManagePlayerGUI_Listener implements Listener {

    @EventHandler
    public void onInventoryDrag(InventoryDragEvent e) {
        if (e.getView().getTitle().equals(ChatColor.RED + "Manage Player")) {
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Player target = Bukkit.getPlayer(event.getView().getItem(22).getItemMeta().getDisplayName());
        if (event.getCurrentItem() == null) {
            return;
        }
        if (target == null) {
            player.closeInventory();
            player.sendMessage("The target is not online.");
        }

        if (event.getCurrentItem().hasItemMeta()) {
            if (Objects.requireNonNull(event.getCurrentItem().getItemMeta()).getDisplayName().equals(ChatColor.DARK_RED + "Kick player")) {
                player.closeInventory();
                try {
                    target.kickPlayer("Kicked by an operator");
                    player.sendMessage(ChatColor.GREEN + "Target player successfully kicked.");
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "An error occurred.");
                    e.printStackTrace();
                }
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "Kill player")) {
                player.closeInventory();
                try {
                    target.setHealth(0);
                    target.sendMessage("Killed by an operator.");
                    player.sendMessage(ChatColor.GREEN + "Target player successfully killed.");
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "An Error occurred.");
                    e.printStackTrace();
                }
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Teleport to player")) {
                player.closeInventory();
                try {
                    assert target != null;
                    player.teleport(target);
                    player.sendMessage(ChatColor.GREEN + "Teleported to player successfully.");
                } catch (Exception e) {
                    player.sendMessage(ChatColor.RED + "An error occurred.");
                    e.printStackTrace();
                }
            } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.YELLOW + "Change gamemode")) {
                player.closeInventory();
                new ManageGamemodeGUI(player, target);
            }
        } else {
            return;
        }
    }
}
