package org.avaeriandev.killchests.chests;

import org.avaeriandev.killchests.KillChestsPlugin;
import org.avaeriandev.killchests.templates.AbstractTemplate;
import org.avaeriandev.killchests.templates.TimerTemplate;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class TimerChest extends AbstractChest {

    private int secondsRequired;
    private int secondsLeft;
    private BukkitTask timer;

    public TimerChest(TimerTemplate template) {
        super(template);
        this.secondsRequired = template.getSecondsRequired();
        this.secondsLeft = secondsRequired;
    }

    public int getSecondsRequired() {
        return secondsRequired;
    }

    public int getSecondsLeft() {
        return secondsLeft;
    }

    @Override
    protected void onSpawn() {
        timer = new BukkitRunnable() {
            @Override
            public void run() {

                if(secondsLeft <= 0) {
                    unlock();
                    cancel();
                }
                secondsLeft--;
                // Update hologram
            }
        }.runTaskTimerAsynchronously(KillChestsPlugin.getInstance(), 0, 20); // 20 ticks per second
    }

    @Override
    protected void onUnlock() {

    }

    @Override
    protected void onDelete() {

    }
}
