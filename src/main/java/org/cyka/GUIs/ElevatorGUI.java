package org.cyka.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ElevatorGUI {

    public ElevatorGUI(Player player, Player target) {
        Inventory inv = Bukkit.createInventory(null,27, ChatColor.RED +"Are you sure?");

        ItemStack yes = new ItemStack(Material.GREEN_CONCRETE, 1);
        ItemMeta yesMeta = yes.getItemMeta();
        yesMeta.setDisplayName(ChatColor.GREEN + "Yes, I want to use the forbidden power.");
        yes.setItemMeta(yesMeta);
        inv.setItem(11, yes);

        ItemStack no = new ItemStack(Material.RED_CONCRETE, 1);
        ItemMeta noMeta = yes.getItemMeta();
        noMeta.setDisplayName(ChatColor.RED + "No.");
        no.setItemMeta(noMeta);
        inv.setItem(15, no);

        ItemStack head = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta headMeta = head.getItemMeta();
        headMeta.setDisplayName(target.getName());
        head.setItemMeta(headMeta);
        inv.setItem(22, head);

        player.openInventory(inv);
    }
}
