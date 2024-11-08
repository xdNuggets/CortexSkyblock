package dev.cortex.skyblock.listeners;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.world.SlimeWorld;
import dev.cortex.skyblock.CortexSkyblock;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.IOException;

public class JoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {

    }

    @EventHandler
    public void onPlayerLeave(PlayerQuitEvent event) throws IOException {
        AdvancedSlimePaperAPI api = CortexSkyblock.getInstance().getAsp();
        SlimeWorld world = api.getLoadedWorld("island_" + event.getPlayer().getUniqueId());
        api.saveWorld(world);
        Bukkit.unloadWorld("island_" + event.getPlayer().getUniqueId(), false);
    }
}
