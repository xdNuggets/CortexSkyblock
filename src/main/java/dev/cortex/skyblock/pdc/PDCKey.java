package dev.cortex.skyblock.pdc;

import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataHolder;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface PDCKey {
    @NotNull JavaPlugin getInstance();

    @NotNull String getKey();

    @NotNull PersistentDataType<?, ?> getType();

    default @Nullable String getString(@Nullable PersistentDataHolder holder) {
        return (String) get(holder);
    }

    default @Nullable Integer getInt(@Nullable PersistentDataHolder holder) {
        return (Integer) get(holder);
    }

    default @Nullable Long getLong(@Nullable PersistentDataHolder holder) {
        return (Long) get(holder);
    }

    default @Nullable Double getDouble(@Nullable PersistentDataHolder holder) {
        return (Double) get(holder);
    }

    default @Nullable Float getFloat(@Nullable PersistentDataHolder holder) {
        return (Float) get(holder);
    }

    default @Nullable Boolean getBoolean(@Nullable PersistentDataHolder holder) {
        return (Boolean) get(holder);
    }

    default <T> void set(@Nullable PersistentDataHolder holder, T value) {
        if (holder == null) return;
        //noinspection unchecked
        PersistentDataType<Object, T> type = (PersistentDataType<Object, T>) getType();
        holder.getPersistentDataContainer().set(getNamespace(), type, value);
    }

    default void remove(@Nullable PersistentDataHolder holder) {
        if (holder == null) return;
        holder.getPersistentDataContainer().remove(getNamespace());
    }

    default @Nullable Object get(@Nullable PersistentDataHolder holder) {
        if (holder == null) return null;
        if (holder instanceof ItemStack && !((ItemStack) holder).hasItemMeta()) return null;
        return holder.getPersistentDataContainer().get(getNamespace(), getType());
    }

    default boolean has(@Nullable PersistentDataHolder holder) {
        if (holder == null) return false;
        if (holder instanceof ItemStack && !((ItemStack) holder).hasItemMeta()) return false;
        return holder.getPersistentDataContainer().has(getNamespace(), getType());
    }

    default @NotNull NamespacedKey getNamespace() {
        return new NamespacedKey(getInstance(), getKey());
    }
}