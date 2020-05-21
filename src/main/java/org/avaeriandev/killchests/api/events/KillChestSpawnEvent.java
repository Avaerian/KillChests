package org.avaeriandev.killchests.api.events;

import org.avaeriandev.killchests.chests.AbstractChest;

public class KillChestSpawnEvent extends KillChestEvent {

    public KillChestSpawnEvent(AbstractChest chest) {
        super(chest);
    }
}
