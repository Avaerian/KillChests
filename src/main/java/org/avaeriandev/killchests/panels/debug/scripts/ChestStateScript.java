package org.avaeriandev.killchests.panels.debug.scripts;

import org.avaeriandev.api.panels.IconScript;
import org.avaeriandev.killchests.chests.AbstractChest;
import org.avaeriandev.killchests.chests.enums.ChestState;
import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class ChestStateScript implements IconScript {

    private ChestState chestState;
    private AbstractChest chest;

    public ChestStateScript(ChestState chestState, AbstractChest chest) {
        this.chestState = chestState;
        this.chest = chest;
    }

    @Override
    public void run(Player plr) {
        chest.setChestState(chestState);
        plr.sendMessage(BaseUtils.chat("&aChest state updated successfully!"));
        plr.playSound(plr.getLocation(), Sound.ENTITY_VILLAGER_YES, 1, 1);
        plr.closeInventory();
    }
}
