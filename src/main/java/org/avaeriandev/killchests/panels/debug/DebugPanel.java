package org.avaeriandev.killchests.panels.debug;

import org.avaeriandev.api.panels.Panel;
import org.avaeriandev.api.panels.PanelIcon;
import org.avaeriandev.killchests.chests.AbstractChest;
import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class DebugPanel extends Panel {

    private static final String header = "Chest Debug Panel";
    private static final int rows = 3;

    private AbstractChest chest;

    public DebugPanel(AbstractChest chest) {
        super(header, rows);
        this.chest = chest;
        setContents();
    }

    private void setContents() {

        Map<Integer, PanelIcon> iconMap = new HashMap<>();

        iconMap.put(1, new PanelIcon("&aUpdate chest state", new ItemStack(Material.GRASS), plr -> {
            plr.playSound(plr.getLocation(), Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 1, 1);
            plr.sendMessage(BaseUtils.chat("&aOpening chest state panel..."));
            plr.closeInventory();
        }));

    }

}
