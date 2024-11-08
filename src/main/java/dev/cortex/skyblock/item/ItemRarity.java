package dev.cortex.skyblock.item;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

@Getter
public enum ItemRarity {
    COMMON("<grey>COMMON</grey>", 0),
    UNCOMMON("<green>UNCOMMON</green>", 1),
    RARE("<#00c3ff>RARE</#00c3ff>", 2),
    EPIC("<#b247ff>EPIC</#b247ff>", 3),
    LEGENDARY("<#ffaf19>LEGENDARY</#ffaf19>", 4),
    MYTHICAL("<#ff2b32>MYTHICAL</#ff2b32>", 5),
    DIVINE("<#00a6a0>DIVING</#00a6a0>", 6);

    private final @NotNull String name;
    private final int tier;

    ItemRarity(@NotNull String name, int tier) {
        this.name = name;
        this.tier = tier;
    }
}