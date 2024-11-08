package dev.cortex.skyblock;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.loaders.file.FileLoader;
import dev.cortex.skyblock.command.admin.CreateIslandCommand;
import dev.cortex.skyblock.command.admin.LoadWorldCommand;
import dev.cortex.skyblock.command.admin.SaveWorldCommand;
import dev.cortex.skyblock.command.admin.TpWorldCommand;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import lombok.Getter;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.io.File;

@Getter
public final class CortexSkyblock extends JavaPlugin {

    private SlimeLoader islandLoader;
    private AdvancedSlimePaperAPI asp;

    @Override
    public void onEnable() {
        this.islandLoader = new FileLoader(new File("player_islands"));
        this.asp = AdvancedSlimePaperAPI.instance();

        @NotNull LifecycleEventManager<Plugin> manager = this.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register("worldtp", new TpWorldCommand());
            commands.register("save", new SaveWorldCommand());
        });

        new CreateIslandCommand().registerCommand();
        new LoadWorldCommand().registerCommand();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CortexSkyblock getInstance() {
        return CortexSkyblock.getPlugin(CortexSkyblock.class);
    }

}
