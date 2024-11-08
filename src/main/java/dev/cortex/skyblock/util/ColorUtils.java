package dev.cortex.skyblock.util;

import lombok.experimental.UtilityClass;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.kyori.adventure.text.serializer.plain.PlainTextComponentSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

/**
 * Handles the conversion of colours
 */
@UtilityClass
public final class ColorUtils {
    public static @NotNull Component color(@NotNull String string, @NotNull TagResolver... resolvers) {
        return MiniMessageConverter.getFromLegacy(string, resolvers);
    }

    public static @NotNull List<Component> color(@NotNull Collection<String> strings, @NotNull TagResolver... resolvers) {
        return strings.stream()
                .map(s -> MiniMessageConverter.getFromLegacy(s, resolvers))
                .toList();
    }

    public static @NotNull String stripColor(@NotNull Component text) {
        return PlainTextComponentSerializer.plainText().serialize(
                LegacyComponentSerializer.legacyAmpersand().deserialize(
                        PlainTextComponentSerializer.plainText().serialize(text)));
    }
}