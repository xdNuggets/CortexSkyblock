package dev.cortex.skyblock.world;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.loaders.SlimeLoader;
import com.infernalsuite.aswm.api.world.SlimeWorld;
import com.infernalsuite.aswm.api.world.properties.SlimeProperties;
import com.infernalsuite.aswm.api.world.properties.SlimePropertyMap;
import dev.cortex.skyblock.CortexSkyblock;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlaceholderCreateIsland {


    // ignore this for now we will remove it at a later point in time :)
    public static void createIsland(Player player) {
        SlimePropertyMap properties = new SlimePropertyMap();

        properties.setValue(SlimeProperties.DIFFICULTY, "normal");
        properties.setValue(SlimeProperties.SPAWN_X, 17);
        properties.setValue(SlimeProperties.SPAWN_Y, 104); // prolly move the island to around 30 later so that players have lots of space to build
        properties.setValue(SlimeProperties.SPAWN_Z, 30);
        properties.setValue(SlimeProperties.ALLOW_ANIMALS, false); // set to true later
        properties.setValue(SlimeProperties.ALLOW_MONSTERS, false); // set to true later
        properties.setValue(SlimeProperties.ENVIRONMENT, "normal");
        properties.setValue(SlimeProperties.WORLD_TYPE, "DEFAULT");
        properties.setValue(SlimeProperties.DEFAULT_BIOME, "minecraft:plains");

        AdvancedSlimePaperAPI api = CortexSkyblock.getInstance().getAsp();
        SlimeLoader loader = CortexSkyblock.getInstance().getIslandLoader();
        try {
            SlimeWorld template = api.readWorld(loader, "player_island_template", true, properties);
            SlimeWorld playerIsland = template.clone("island_" + player.getUniqueId(), loader);
            player.sendMessage("Your island has been created!");
            api.loadWorld(playerIsland, true);
            player.sendMessage("Teleporting you to your island...");
            player.teleport(new Location(Bukkit.getWorld(playerIsland.getName()), 58, 61, 60));
            player.sendMessage("Good luck!");
        } catch (Exception e) {
            player.sendMessage("An error occurred while creating your island. Please contact an administrator.");
            e.printStackTrace();
        }



    }
}
