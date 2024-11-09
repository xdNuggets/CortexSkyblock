package dev.cortex.skyblock;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.loaders.file.FileLoader;
import dev.cortex.skyblock.command.admin.CreateIslandCommand;
import dev.cortex.skyblock.command.admin.LoadWorldCommand;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public final class CortexSkyblock extends JavaPlugin {
    public static CortexSkyblock instance;
    private SlimeLoader islandLoader;
    private AdvancedSlimePaperAPI api;

    @Override
    public void onLoad() {
        instance = this;
    }

    @Override
    @SuppressWarnings("UnstableApiUsage")
    public void onEnable() {
        this.islandLoader = new FileLoader(new File("player_islands"));
        this.api = AdvancedSlimePaperAPI.instance();

        new CreateIslandCommand();
        new LoadWorldCommand();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
