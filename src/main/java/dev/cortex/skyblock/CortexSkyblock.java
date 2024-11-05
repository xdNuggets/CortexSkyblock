package dev.cortex.skyblock;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.loaders.file.FileLoader;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

@Getter
public final class CortexSkyblock extends JavaPlugin {

    private SlimeLoader islandLoader;
    private AdvancedSlimePaperAPI asp;

    @Override
    public void onEnable() {
        this.islandLoader = new FileLoader(new File("player_islands"));
        this.asp = AdvancedSlimePaperAPI.instance();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static CortexSkyblock getInstance() {
        return CortexSkyblock.getPlugin(CortexSkyblock.class);
    }

}
