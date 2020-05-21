package org.avaeriandev.killchests.listeners;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.avaeriandev.killchests.KillChests;
import org.avaeriandev.killchests.KillChestsPlugin;
import org.avaeriandev.killchests.chests.SoulChest;
import org.avaeriandev.killchests.chests.enums.ChestState;
import org.avaeriandev.killchests.utils.WorldGuardUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.ArrayList;
import java.util.List;

public class KillListener implements Listener {

    public KillListener() {
        Bukkit.getPluginManager().registerEvents(this, KillChestsPlugin.getInstance());
    }

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent e) {
        Player victim = e.getEntity();
        Player killer = e.getEntity().getKiller();
        if(killer == null) return;

        List<ProtectedRegion> victimRegions = WorldGuardUtils.getRegionsFromLocation(victim.getLocation());
        List<ProtectedRegion> killerRegions = WorldGuardUtils.getRegionsFromLocation(killer.getLocation());

        List<SoulChest> soulChests = (List<SoulChest>) KillChests.getInstance().getActiveKillChests()
                .stream()
                .filter(chest -> chest instanceof SoulChest)
                .filter(chest -> chest.getChestState() == ChestState.LOCKED);

        for(SoulChest chest : soulChests) {
            ProtectedRegion chestRegion = chest.getRegion();
            if(victimRegions.contains(chestRegion) && killerRegions.contains(chestRegion)) {
                chest.addKill();
            }
        }

    }

}
