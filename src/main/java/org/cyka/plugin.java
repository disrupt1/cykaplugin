package org.cyka;

import org.bukkit.plugin.java.JavaPlugin;
import org.cyka.commands.ManagePlayer;
import org.cyka.commands.PlayerTracker;
import org.cyka.listeners.ManageGamemode_Listener;
import org.cyka.listeners.ManagePlayerGUI_Listener;
import org.cyka.listeners.PlayerjoinListener;

public final class plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // on start logic
        System.out.println("Plugin started.");
        getServer().getPluginManager().registerEvents(new PlayerjoinListener(), this);
        getCommand("manage").setExecutor(new ManagePlayer());
        getServer().getPluginManager().registerEvents(new ManagePlayerGUI_Listener(), this);
        getServer().getPluginManager().registerEvents(new ManageGamemode_Listener(), this);
        getCommand("track").setExecutor(new PlayerTracker());
    }

    @Override
    public void onDisable() {
        // on shut down logic
    }
}