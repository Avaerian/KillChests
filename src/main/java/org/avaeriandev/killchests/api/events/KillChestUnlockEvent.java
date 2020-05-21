package org.avaeriandev.killchests.api.events;

import org.avaeriandev.killchests.chests.AbstractChest;

public class KillChestUnlockEvent extends KillChestEvent {

    public KillChestUnlockEvent(AbstractChest chest) {
        super(chest);
    }
}
