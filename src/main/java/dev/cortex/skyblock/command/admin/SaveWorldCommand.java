package dev.cortex.skyblock.command.admin;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import dev.cortex.skyblock.CortexSkyblock;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class SaveWorldCommand implements BasicCommand {
    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] args) {
        AdvancedSlimePaperAPI api = CortexSkyblock.instance.getAsp();
        try {
            api.saveWorld(api.getLoadedWorld(args[0]));
            commandSourceStack.getSender().sendMessage("World saved!");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
