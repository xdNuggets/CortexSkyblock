package dev.cortex.skyblock.gui;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import dev.cortex.skyblock.CortexSkyblock;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.function.Consumer;

public class MenuItemBuilder {

    private ItemStack item;
    private ItemMeta meta;

    public MenuItemBuilder(ItemStack item) {
        this.item = item;
        this.meta = item.getItemMeta();
    }

    public MenuItemBuilder name(String name) {
        meta.setDisplayName(name);
        return this;
    }

    public MenuItemBuilder lore(String... lore) {
        meta.setLore(Arrays.asList(lore));
        return this;
    }

    public MenuItemBuilder amount(int amount) {
        item.setAmount(amount);
        return this;
    }

    public MenuItemBuilder durability(int durability) {
        item.setDurability((short) durability);
        return this;
    }

    public MenuItemBuilder flags(ItemFlag... flags) {
        meta.addItemFlags(flags);
        return this;
    }


    public GuiItem build(@Nullable Consumer<InventoryClickEvent> action) {
        return new GuiItem(item, action, CortexSkyblock.instance);
    }
}
