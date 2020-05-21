package org.avaeriandev.killchests;

import org.avaeriandev.killchests.listeners.KillListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class KillChestsPlugin extends JavaPlugin {

    private static KillChestsPlugin instance;

    public void onEnable() {
        instance = this;

        // Register event listeners
        new KillListener();
    }

    public static KillChestsPlugin getInstance() {
        return instance;
    }

}
