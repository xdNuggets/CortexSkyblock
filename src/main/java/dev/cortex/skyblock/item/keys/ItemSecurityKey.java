package dev.cortex.skyblock.item.keys;

import com.jeff_media.morepersistentdatatypes.DataType;
import dev.cortex.skyblock.CortexSkyblock;
import dev.cortex.skyblock.pdc.PDCKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.bukkit.persistence.PersistentDataType;

/**
 * This class acts as a "security key" for items with a rarity of legendary or higher.
 * Each item with a rarity of legendary or higher will have a unique security key.
 * This will be used to combat duplication exploits.
 */

@Getter
@AllArgsConstructor
public enum ItemSecurityKey implements PDCKey {
    SECURITY_KEY("security", DataType.UUID);

    private final String key;
    private final PersistentDataType<?, ?> type;
    private final CortexSkyblock instance = CortexSkyblock.instance;
}