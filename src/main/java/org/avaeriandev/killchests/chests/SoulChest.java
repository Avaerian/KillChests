package org.avaeriandev.killchests.chests;

import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.avaeriandev.killchests.templates.SoulTemplate;
import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoulChest extends AbstractChest {

    private int killsRequired;
    private int killCount;
    private ProtectedRegion region;

    public SoulChest(SoulTemplate template) {
        super(template);
        this.killsRequired = template.getKillsRequired();
        this.killCount = 0;
        this.region = template.getRegion();
    }

    public int getKillsRequired() {
        return killsRequired;
    }

    public ProtectedRegion getRegion() {
        return region;
    }

    public void addKill() {
        killCount++;
    }

    @Override
    protected void onSpawn() {
        Bukkit.broadcastMessage(BaseUtils.chat("&aA soul chest has spawned!"));
        Bukkit.getOnlinePlayers().forEach(plr -> plr.playSound(plr.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1));
    }

    @Override
    protected void onUnlock() {
        Bukkit.broadcastMessage(BaseUtils.chat("&aA soul chest has been unlocked!"));
    }

    @Override
    protected void onDelete() {
        Bukkit.broadcastMessage(BaseUtils.chat("&cThe soul chest event has ended. Come back soon!"));
    }
}
