package org.cyka;

import org.bukkit.plugin.java.JavaPlugin;
import org.cyka.commands.*;
import org.cyka.listeners.*;

public final class plugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // on start logic
        System.out.println("Plugin started.");
        getServer().getPluginManager().registerEvents(new PlayerjoinListener(), this);
        getServer().getPluginManager().registerEvents(new ManagePlayerGUI_Listener(), this);
        getServer().getPluginManager().registerEvents(new ManageGamemode_Listener(), this);
        getServer().getPluginManager().registerEvents(new CancelInventory(), this);
        getServer().getPluginManager().registerEvents(new ElevatorListener(), this);
        getCommand("track").setExecutor( new PlayerTracker());
        getCommand("manage").setExecutor(new ManagePlayer());
        getCommand("heal").setExecutor(new HealPlayer());
        getCommand("ping").setExecutor(new PlayerPing());
        getCommand("feed").setExecutor(new FeedPlayer());
        getCommand("elevator").setExecutor(new Elevator());
    }

    @Override
    public void onDisable() {
        // on shut down logic
    }
}