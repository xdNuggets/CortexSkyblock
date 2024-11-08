package dev.cortex.skyblock.command.admin;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.world.SlimeWorld;
import dev.cortex.skyblock.CortexSkyblock;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class LoadWorldCommand {
    public LoadWorldCommand() {
        new CommandAPICommand("loadworld")
                .withArguments(new StringArgument("world"))
                .executesPlayer(this::onLoadWorld)
                .register();
    }

    void onLoadWorld(@NotNull Player player, @NotNull CommandArguments args) {
        AdvancedSlimePaperAPI api = CortexSkyblock.instance.getAsp();
        try {
            SlimeWorld world = api.readWorld(CortexSkyblock.instance.getIslandLoader(), args.getRaw(0), false, null);
            api.loadWorld(world, true);
            player.sendMessage("World loaded!");
        } catch (Exception e) {
            player.sendMessage("An error occurred while loading the world. Please contact an administrator.");
        }
    }
}
