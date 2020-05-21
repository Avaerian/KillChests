package org.avaeriandev.killchests.listeners;

import org.avaeriandev.killchests.KillChests;
import org.avaeriandev.killchests.KillChestsPlugin;
import org.avaeriandev.killchests.chests.AbstractChest;
import org.avaeriandev.killchests.chests.enums.ChestState;
import org.avaeriandev.killchests.panels.debug.DebugPanel;
import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ChestInteractListener implements Listener {

    public ChestInteractListener() {
        Bukkit.getPluginManager().registerEvents(this, KillChestsPlugin.getInstance());
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player plr = e.getPlayer();
        AbstractChest chest = null;

        if(e.getAction() != Action.RIGHT_CLICK_BLOCK) return;

        for(AbstractChest activeChest : KillChests.getInstance().getActiveKillChests()) {
            if(activeChest.getBlock().equals(e.getClickedBlock())) {
                chest = activeChest;
                break;
            }
        }
        if(chest == null) return;

        if(chest.isDebugMode()) {
            if(plr.hasPermission("killchests.admin")) {
                plr.openInventory(new DebugPanel(chest).getPanel());
            }
        }

        if(chest.getChestState() == ChestState.LOCKED) {
            plr.sendMessage(BaseUtils.chat("&cThe chest is locked!"));
            e.setCancelled(true);
            return;
        }
    }

}
