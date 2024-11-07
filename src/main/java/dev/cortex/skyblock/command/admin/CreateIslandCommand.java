package dev.cortex.skyblock.command.admin;

import dev.cortex.skyblock.world.PlaceholderCreateIsland;
import dev.jorel.commandapi.CommandAPICommand;

public class CreateIslandCommand {

    public void registerCommand() {
        new CommandAPICommand("createisland")
                .executesPlayer((player, args) -> {
                    PlaceholderCreateIsland.createIsland(player);
                })
                .register();
    }
}
