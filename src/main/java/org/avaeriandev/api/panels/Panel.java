package org.avaeriandev.api.panels;

import org.avaeriandev.killchests.KillChestsPlugin;
import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public abstract class Panel implements Listener {

    private Inventory panel;
    private Map<Integer, PanelIcon> iconMap;

    public Panel(String header, int rows) {
        panel = Bukkit.createInventory(null, rows * 9, BaseUtils.chat(header));
        iconMap = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(this, KillChestsPlugin.getInstance());
    }

    public Panel(String header, InventoryType inventoryType) {
        panel = Bukkit.createInventory(null, inventoryType, BaseUtils.chat(header));
        iconMap = new HashMap<>();
        Bukkit.getPluginManager().registerEvents(this, KillChestsPlugin.getInstance());
    }

    protected void loadContents(Map<Integer, PanelIcon> rawIconMap) {
        for(Map.Entry<Integer, PanelIcon> entry : rawIconMap.entrySet()) {
            PanelIcon icon = entry.getValue();
            int slot = entry.getKey() - 1;
            iconMap.put(slot, icon);
        }
    }

    public Inventory getPanel() {
        return panel;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        Player plr = (Player) e.getWhoClicked();

        if(!e.getClickedInventory().equals(panel)) return;

        if(e.getSlotType() == InventoryType.SlotType.OUTSIDE) plr.closeInventory();

        if(iconMap.containsKey(e.getRawSlot())) {
            PanelIcon icon = iconMap.get(e.getRawSlot());
            if(icon.getScript() != null) icon.getScript().run(plr);
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if(e.getInventory().equals(panel)) {
            HandlerList.unregisterAll(this);
        }
    }

}
