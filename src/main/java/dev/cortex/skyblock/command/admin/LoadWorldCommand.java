package dev.cortex.skyblock.command.admin;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.world.SlimeWorld;
import dev.cortex.skyblock.CortexSkyblock;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import dev.jorel.commandapi.executors.CommandArguments;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LoadWorldCommand {

    public void registerCommand() {
        new CommandAPICommand("loadworld")
                .withArguments(new StringArgument("world"))
                .executesPlayer(this::execute)
                .register();
    }

    void execute(CommandSender sender, CommandArguments args) {
        Player player = (Player) sender;
        AdvancedSlimePaperAPI api = CortexSkyblock.getInstance().getAsp();
        try {

            SlimeWorld world = api.readWorld(CortexSkyblock.getInstance().getIslandLoader(), args.getRaw(0), false, null);
            api.loadWorld(world, true);
            player.sendMessage("World loaded!");
        } catch (Exception e) {
            player.sendMessage("An error occurred while loading the world. Please contact an administrator.");
        }
    }
}
