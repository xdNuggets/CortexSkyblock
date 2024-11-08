package dev.cortex.skyblock.item.keys;


import com.jeff_media.morepersistentdatatypes.DataType;
import dev.cortex.skyblock.CortexSkyblock;
import dev.cortex.skyblock.pdc.PDCKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.persistence.PersistentDataType;

@Getter
@AllArgsConstructor
public enum ItemRarityKey implements PDCKey {
    RARITY_KEY("rarity", DataType.INTEGER);

    private final String key;
    private final PersistentDataType<?, ?> type;
    private final CortexSkyblock instance = CortexSkyblock.instance;
}