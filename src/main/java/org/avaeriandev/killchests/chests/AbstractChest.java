package org.avaeriandev.killchests.chests;

import org.avaeriandev.killchests.KillChests;
import org.avaeriandev.killchests.api.events.KillChestDeleteEvent;
import org.avaeriandev.killchests.api.events.KillChestSpawnEvent;
import org.avaeriandev.killchests.api.events.KillChestUnlockEvent;
import org.avaeriandev.killchests.chests.enums.ChestState;
import org.avaeriandev.killchests.templates.AbstractTemplate;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.inventory.Inventory;

import java.util.Random;

public abstract class AbstractChest {

    private Block block;
    private Inventory inventory;
    private ChestState chestState;
    private AbstractTemplate template;

    private boolean isDebugMode;
    private int cleanupCountdown;

    public AbstractChest(AbstractTemplate template) {
        this.template = template;

        // Prepare block
        int locIndex = new Random().nextInt(template.getPossibleLocations().size());
        this.block = template.getPossibleLocations().get(locIndex).getBlock();
        this.block.setType(template.getBlockMaterial());

        this.isDebugMode = template.getDebugMode();

        this.chestState = ChestState.LOCKED;

        KillChests.getInstance().addChest(this);
        Bukkit.getPluginManager().callEvent(new KillChestSpawnEvent(this));
        onSpawn();
    }

    public void setChestState(ChestState chestState) {
        this.chestState = chestState;
    }

    public void unlock() {
        chestState = ChestState.UNLOCKED;
        Bukkit.getPluginManager().callEvent(new KillChestUnlockEvent(this));
        onUnlock();
    }

    public void delete() {
        chestState = ChestState.DELETED;
        Bukkit.getPluginManager().callEvent(new KillChestDeleteEvent(this));
        KillChests.getInstance().removeChest(this);
        onDelete();
    }

    protected abstract void onSpawn();
    protected abstract void onUnlock();
    protected abstract void onDelete();

    public AbstractTemplate getTemplate() {
        return template;
    }

    public ChestState getChestState() {
        return chestState;
    }

    public Block getBlock() {
        return block;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public boolean isDebugMode() {
        return isDebugMode;
    }

    public int getCleanupCountdown() {
        return cleanupCountdown;
    }

}
