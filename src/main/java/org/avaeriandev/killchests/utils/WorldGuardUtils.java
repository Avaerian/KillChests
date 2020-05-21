package org.avaeriandev.killchests.utils;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class WorldGuardUtils {

    private static RegionManager getRegionManager(World world) {
        return WorldGuard.getInstance().getPlatform().getRegionContainer().get(BukkitAdapter.adapt(world));
    }

    public static List<Player> getPlayersInRegion(ProtectedRegion region) {
        List<Player> plrs = new ArrayList<>(Bukkit.getOnlinePlayers());
        plrs.removeIf(plr -> !region.contains(BukkitAdapter.asBlockVector(plr.getLocation())));
        return plrs;
    }

    public static boolean isPlayerInRegion(Player plr, ProtectedRegion region) {
        return region.contains(BukkitAdapter.asBlockVector(plr.getLocation()));
    }

    public static ProtectedRegion getRegion(String regionName, String regionWorld) {

        World world = Bukkit.getWorld(regionWorld);
        if(world == null) return null;

        ProtectedRegion region = getRegionManager(world).getRegion(regionName);
        return region;
    }

    public static List<ProtectedRegion> getRegionsFromLocation(Location location) {
        return new ArrayList<>(getRegionManager(location.getWorld()).getApplicableRegions(BukkitAdapter.asBlockVector(location)).getRegions());
    }

}
