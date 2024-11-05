package dev.cortex.skyblock.command;

import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class TpWorldCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] strings) {
        Player player = (Player) commandSourceStack.getSender();
        player.teleport(new Location(Bukkit.getWorld(""), 50, 60, 100));
    }
}
