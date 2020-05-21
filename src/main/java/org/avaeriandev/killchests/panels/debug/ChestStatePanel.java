package org.avaeriandev.killchests.panels.debug;

import org.avaeriandev.api.panels.Panel;
import org.avaeriandev.api.panels.PanelIcon;
import org.avaeriandev.killchests.chests.AbstractChest;
import org.avaeriandev.killchests.chests.enums.ChestState;
import org.avaeriandev.killchests.panels.debug.scripts.ChestStateScript;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class ChestStatePanel extends Panel {

    private static final String header = "Update Chest State";
    private static final int rows = 1;

    private AbstractChest chest;

    public ChestStatePanel(AbstractChest chest) {
        super(header, rows);
        this.chest = chest;
        setContents();
    }

    private void setContents() {

        Map<Integer, PanelIcon> iconMap = new HashMap<>();

        iconMap.put(1, new PanelIcon("&c&lLocked State", new ItemStack(Material.RED_STAINED_GLASS_PANE), new ChestStateScript(ChestState.LOCKED, chest)));
        iconMap.put(2, new PanelIcon("&6&lUnlocked State", new ItemStack(Material.YELLOW_STAINED_GLASS_PANE), new ChestStateScript(ChestState.UNLOCKED, chest)));

        super.loadContents(iconMap);
    }

}
