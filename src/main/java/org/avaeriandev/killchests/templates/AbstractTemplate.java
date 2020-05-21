package org.avaeriandev.killchests.templates;

import org.avaeriandev.killchests.templates.enums.YamlLoadStatus;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

public abstract class AbstractTemplate {

    private YamlConfiguration config;
    private YamlLoadStatus loadStatus;

    private Material blockMaterial;
    private List<Location> possibleLocations;
    private boolean isDebugMode;

    public AbstractTemplate(YamlConfiguration config) {
        this.config = config;
        this.loadStatus = YamlLoadStatus.LOADING;

        this.blockMaterial = (Material) attemptToLoad("block-material");
        this.possibleLocations = (List<Location>) attemptToLoad("possible-locations");
        this.isDebugMode = (boolean) attemptToLoad("debug-mode");
    }

    public Material getBlockMaterial() {
        return blockMaterial;
    }

    public List<Location> getPossibleLocations() {
        return possibleLocations;
    }

    public boolean getDebugMode() {
        return isDebugMode;
    }

    protected Object attemptToLoad(String path) {
        return config.contains(path) ? config.get(path) : null;
    }

}
