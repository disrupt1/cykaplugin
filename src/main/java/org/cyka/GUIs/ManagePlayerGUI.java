package org.cyka.GUIs;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ManagePlayerGUI {

    public ManagePlayerGUI (Player player, Player target) {
        Inventory inventory = Bukkit.createInventory(null, 27, ChatColor.RED +"Manage Player");

        ItemStack targetHead = new ItemStack(Material.PLAYER_HEAD, 1);
        ItemMeta targetHeadMeta = targetHead.getItemMeta();
        assert targetHeadMeta != null;
        targetHeadMeta.setDisplayName(target.getName());
        targetHead.setItemMeta(targetHeadMeta);
        inventory.setItem(22, targetHead);

        ItemStack kick = new ItemStack(Material.RED_DYE, 1);
        ItemMeta kickMeta = kick.getItemMeta();
        kickMeta.setDisplayName(ChatColor.DARK_RED + "Kick player");
        kickMeta.setLore(Arrays.asList("Kick the player from the server."));
        kick.setItemMeta(kickMeta);
        inventory.setItem(11, kick);

        ItemStack kill = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta killMeta = kill.getItemMeta();
        killMeta.setDisplayName(ChatColor.RED + "Kill player");
        killMeta.setLore(Arrays.asList("Kill the player."));
        kill.setItemMeta(killMeta);
        inventory.setItem(13, kill);

        ItemStack teleport = new ItemStack(Material.ENDER_PEARL, 1);
        ItemMeta clearMeta = teleport.getItemMeta();
        clearMeta.setDisplayName(ChatColor.DARK_PURPLE + "Teleport to player");
        clearMeta.setLore(Arrays.asList("Teleports to the player."));
        teleport.setItemMeta(clearMeta);
        inventory.setItem(15, teleport);

        ItemStack gamemode = new ItemStack(Material.DIAMOND_PICKAXE, 1);
        ItemMeta gamemodeMeta = gamemode.getItemMeta();
        gamemodeMeta.setDisplayName(ChatColor.YELLOW + "Change gamemode");
        gamemodeMeta.setLore(Arrays.asList("Change the game mode of the selected player."));
        gamemode.setItemMeta(gamemodeMeta);
        inventory.setItem(4, gamemode);

        player.openInventory(inventory);
    }
}
