package dev.cortex.skyblock;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.loaders.file.FileLoader;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class CortexSkyblock extends JavaPlugin {

    private SlimeLoader islandLoader;
    private AdvancedSlimePaperAPI asp;

    @Override
    public void onEnable() {
        islandLoader = new FileLoader(new File("player_islands"));
        asp = AdvancedSlimePaperAPI.instance();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public SlimeLoader getIslandLoader() {
        return islandLoader;
    }

    public static CortexSkyblock getInstance() {
        return CortexSkyblock.getPlugin(CortexSkyblock.class);
    }

    public AdvancedSlimePaperAPI getSlimeAPI() {
        return asp;
    }

}
