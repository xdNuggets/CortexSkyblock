package dev.cortex.skyblock.item;

import dev.cortex.skyblock.item.keys.ItemRarityKey;
import dev.cortex.skyblock.item.keys.ItemSecurityKey;
import dev.cortex.skyblock.util.ColorUtils;
import dev.cortex.skyblock.util.UUIDUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ItemWrapper {
    public @NotNull ItemStack create(@NotNull ItemStack item, @NotNull ItemRarity rarity) {
        ItemRarityKey.RARITY_KEY.set(item.getItemMeta(), rarity.getTier());

        // Add rarity to the bottom of the lore.
        item.editMeta(meta -> {
            List<Component> lore = meta.lore();
            if (lore == null)
                lore = new ArrayList<>();
            lore.add(ColorUtils.color(rarity.getName()));
            meta.lore(lore);
        });

        if (rarity == ItemRarity.LEGENDARY || rarity == ItemRarity.MYTHICAL || rarity == ItemRarity.DIVINE)
            ItemSecurityKey.SECURITY_KEY.set(item.getItemMeta(), UUIDUtils.getTimedUUID());

        return item;
    }
}
