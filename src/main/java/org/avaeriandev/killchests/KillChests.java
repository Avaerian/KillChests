package org.avaeriandev.killchests;

import org.avaeriandev.killchests.chests.AbstractChest;

import java.util.ArrayList;
import java.util.List;

public class KillChests {

    private List<AbstractChest> activeKillChests = new ArrayList<>();

    private static KillChests instance = null;

    public static KillChests getInstance() {
        if(instance == null) instance = new KillChests();
        return instance;
    }
    private KillChests() {}

    public List<AbstractChest> getActiveKillChests() {
        return activeKillChests;
    }

    public void addChest(AbstractChest chest) {
        if(!activeKillChests.contains(chest)) activeKillChests.add(chest);
    }

    public void removeChest(AbstractChest chest) {
        activeKillChests.remove(chest);
    }

}
