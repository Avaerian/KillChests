package org.avaeriandev.api.panels;

import org.avaeriandev.killchests.utils.BaseUtils;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class PanelIcon {

    private ItemStack icon;
    private IconScript script;

    public PanelIcon(String title, List<String> lore, ItemStack icon, IconScript script) {
        this.icon = createIcon(title, lore, icon);
        this.script = script;
    }

    public PanelIcon(String title, ItemStack icon, IconScript script) {
        this.icon = createIcon(title, icon);
        this.script = script;
    }

    public ItemStack getIcon() {
        return icon;
    }

    public IconScript getScript() {
        return script;
    }

    private ItemStack createIcon(String title, List<String> lore, ItemStack icon) {
        ItemMeta meta = icon.getItemMeta();

        meta.setDisplayName(BaseUtils.chat(title));
        meta.setLore(BaseUtils.lore(lore));
        meta.addItemFlags(ItemFlag.values());

        icon.setItemMeta(meta);
        return icon;
    }

    private ItemStack createIcon(String title, ItemStack icon) {
        ItemMeta meta = icon.getItemMeta();

        meta.setDisplayName(BaseUtils.chat(title));
        meta.addItemFlags(ItemFlag.values());

        icon.setItemMeta(meta);
        return icon;
    }

}
