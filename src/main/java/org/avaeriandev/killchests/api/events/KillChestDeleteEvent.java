package org.avaeriandev.killchests.api.events;

import org.avaeriandev.killchests.chests.AbstractChest;

public class KillChestDeleteEvent extends KillChestEvent {

    public KillChestDeleteEvent(AbstractChest chest) {
        super(chest);
    }
}
