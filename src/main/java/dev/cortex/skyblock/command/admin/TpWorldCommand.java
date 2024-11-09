package dev.cortex.skyblock.command.admin;

import dev.jorel.commandapi.CommandAPICommand;
import dev.jorel.commandapi.arguments.StringArgument;
import org.bukkit.Bukkit;
import org.bukkit.Location;

public class TpWorldCommand {

    public TpWorldCommand() {
        new CommandAPICommand("worldtp")
                .withArguments(
                        new StringArgument("worldname")
                ).executesPlayer((player, args) -> {
                    String worldName = (String) args.get("worldname");
                    player.teleport(new Location(Bukkit.getWorld(worldName), 0, 100, 0));
                });
    }
}
