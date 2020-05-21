package org.avaeriandev.killchests.api.events;

import org.avaeriandev.killchests.chests.AbstractChest;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public abstract class KillChestEvent extends Event {

    private static final HandlerList handlerList = new HandlerList();

    private AbstractChest chest;

    public KillChestEvent(AbstractChest chest) {
        this.chest = chest;
    }

    public AbstractChest getChest() {
        return chest;
    }

    @Override
    public HandlerList getHandlers() {
        return handlerList;
    }

    public static HandlerList getHandlerList() {
        return handlerList;
    }
}
