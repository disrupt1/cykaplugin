package org.cyka.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class CancelInventory implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getView().getTitle().equals(ChatColor.RED + "Manage Player") || e.getView().getTitle().equals(ChatColor.RED + "Manage Gamemode")) {
            e.setCancelled(true);
        }
    }

}
