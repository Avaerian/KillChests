package org.avaeriandev.killchests.templates;

import org.bukkit.configuration.file.YamlConfiguration;

public class TimerTemplate extends AbstractTemplate {

    private int secondsRequired;

    public TimerTemplate(YamlConfiguration config) {
        super(config);
        this.secondsRequired = (int) super.attemptToLoad("seconds-required");
    }

    public int getSecondsRequired() {
        return secondsRequired;
    }

}
