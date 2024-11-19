package org.cyka.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ManageGamemodeGUI {

    public ManageGamemodeGUI(Player player, Player target) {

        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.RED + "Manage Gamemode");

        ItemStack creative = new ItemStack(Material.BEDROCK, 1);
        ItemMeta creativeMeta = creative.getItemMeta();
        creativeMeta.setDisplayName(ChatColor.DARK_PURPLE + "Creative");
        creative.setItemMeta(creativeMeta);
        inv.setItem(10, creative);

        ItemStack survival = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta survivalMeta = survival.getItemMeta();
        survivalMeta.setDisplayName(ChatColor.GREEN + "Survival");
        survival.setItemMeta(survivalMeta);
        inv.setItem(12, survival);

        ItemStack adventure = new ItemStack(Material.PAPER, 1);
        ItemMeta adventureMeta = adventure.getItemMeta();
        adventureMeta.setDisplayName(ChatColor.WHITE + "Adventure");
        adventure.setItemMeta(adventureMeta);
        inv.setItem(14, adventure);

        ItemStack spectator = new ItemStack(Material.LEGACY_EYE_OF_ENDER, 1);
        ItemMeta spectatorMeta = spectator.getItemMeta();
        spectatorMeta.setDisplayName(ChatColor.GRAY + "Spectator");
        spectator.setItemMeta(spectatorMeta);
        inv.setItem(16, spectator);

        ItemStack targetHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta targetHeadMeta = targetHead.getItemMeta();
        targetHeadMeta.setDisplayName(target.getName());
        targetHead.setItemMeta(targetHeadMeta);
        inv.setItem(22, targetHead);

        player.openInventory(inv);

    }
}
