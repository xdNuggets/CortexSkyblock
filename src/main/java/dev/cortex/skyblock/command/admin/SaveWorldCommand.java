package dev.cortex.skyblock.command.admin;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import dev.cortex.skyblock.CortexSkyblock;
import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;

public class SaveWorldCommand {

    public SaveWorldCommand() {
        new CommandAPICommand("save")
                .withArguments(
                        new StringArgument("worldname")
                ).executesPlayer((player, args) -> {
                    String worldName = (String) args.get("worldname");
                    AdvancedSlimePaperAPI api = CortexSkyblock.instance.getApi();
                    try {
                        api.saveWorld(api.getLoadedWorld(args.get("worldname").toString()));
                        player.sendMessage("World saved!");
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
    }
}
