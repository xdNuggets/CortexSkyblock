package dev.cortex.skyblock.gui;

import com.github.stefvanschie.inventoryframework.gui.GuiItem;
import com.github.stefvanschie.inventoryframework.gui.type.ChestGui;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class Menu {

    public String title;
    public int rows;
    public ChestGui gui;

    public Menu(String title, int rows) {
        this.title = title;
        this.rows = rows;
        this.gui = new ChestGui(rows, title);
    }

    public void open(Player player) {
        gui.show(player);
    }

    public void close(Player player) {
        player.closeInventory();
    }

    public abstract void setView();

    public void fill() {
        OutlinePane pane = new OutlinePane(0, 0, 9, rows, Pane.Priority.LOWEST);
        pane.addItem(new GuiItem(new ItemStack(Material.GRAY_STAINED_GLASS_PANE)));
        pane.setRepeat(true);
        gui.addPane(pane);

    }

}
