package org.cyka.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryDragEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ElevatorListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player target = Bukkit.getPlayer(event.getInventory().getItem(22).getItemMeta().getDisplayName());
        Player player = (Player) event.getWhoClicked();
        if (event.getView().getTitle().equals(ChatColor.RED + "Are you sure?")) {
            event.setCancelled(true);
        }
        if (event.getCurrentItem() == null) {
            return;
        }
        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player is not online.");
            player.closeInventory();
        }

        if (event.getCurrentItem().hasItemMeta()) {
            try {
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.GREEN + "Yes, I want to use the forbidden power.")) {
                    target.addPotionEffect(new PotionEffect(PotionEffectType.SLOWNESS, 100, 99));
                    target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 99));
                    target.sendMessage(ChatColor.RED + "You have been stunned by the power of " + ChatColor.YELLOW + "\"The Elevator\".");
                    Thread.sleep(4300);
                    target.kickPlayer("aman az asansor");
                    player.sendMessage(ChatColor.GREEN + "The player has been cursed.");
                } else if (event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatColor.RED + "No.")) {
                    player.closeInventory();
                }
            } catch (Exception e) {
                player.sendMessage(ChatColor.RED + "An error occurred.");
                e.printStackTrace();
            }
        } else {
            return;
        }
    }
}
