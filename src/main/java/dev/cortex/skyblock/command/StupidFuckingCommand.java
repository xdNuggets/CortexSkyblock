package dev.cortex.skyblock.command;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.world.properties.SlimePropertyMap;
import dev.cortex.skyblock.CortexSkyblock;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

public class StupidFuckingCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] strings) {
        AdvancedSlimePaperAPI api = CortexSkyblock.getInstance().getSlimeAPI();
        api.createEmptyWorld("island", false, new SlimePropertyMap(), CortexSkyblock.getInstance().getIslandLoader());

    }
}
