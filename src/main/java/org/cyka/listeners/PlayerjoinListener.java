package org.cyka.listeners;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerjoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        String playerName = event.getPlayer().getDisplayName();
        event.setJoinMessage(ChatColor.GREEN + "Idiot by the name of " + ChatColor.YELLOW + playerName + ChatColor.GREEN + " has joined the server.");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        String playerName = event.getPlayer().getDisplayName();
        event.setQuitMessage(ChatColor.YELLOW + playerName + ChatColor.RED + " Left this piece of shit server.");
    }

}