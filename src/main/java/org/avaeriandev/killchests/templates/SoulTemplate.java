package org.avaeriandev.killchests.templates;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.avaeriandev.killchests.utils.WorldGuardUtils;
import org.bukkit.configuration.file.YamlConfiguration;

public class SoulTemplate extends AbstractTemplate {

    private int killsRequired;
    private ProtectedRegion region;

    public SoulTemplate(YamlConfiguration config) {
        super(config);
        killsRequired = (int) super.attemptToLoad("kills-required");

        // Attempt to get region
        String regionName = String.valueOf(super.attemptToLoad("region.name"));
        String regionWorld = String.valueOf(super.attemptToLoad("region.world"));
        ProtectedRegion region = WorldGuardUtils.getRegion(regionName, regionWorld);
    }

    public int getKillsRequired() {
        return killsRequired;
    }

    public ProtectedRegion getRegion() {
        return region;
    }

}
