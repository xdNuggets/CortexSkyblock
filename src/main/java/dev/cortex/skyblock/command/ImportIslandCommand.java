package dev.cortex.skyblock.command;

import com.infernalsuite.aswm.api.AdvancedSlimePaperAPI;
import com.infernalsuite.aswm.api.exceptions.InvalidWorldException;
import com.infernalsuite.aswm.api.exceptions.WorldAlreadyExistsException;
import com.infernalsuite.aswm.api.exceptions.WorldLoadedException;
import com.infernalsuite.aswm.api.exceptions.WorldTooBigException;
import com.infernalsuite.aswm.api.world.SlimeWorld;
import dev.cortex.skyblock.CortexSkyblock;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;

import java.io.File;
import java.io.IOException;

public class ImportIslandCommand implements BasicCommand {

    @Override
    public void execute(CommandSourceStack commandSourceStack, String[] strings) {
        AdvancedSlimePaperAPI api = CortexSkyblock.getInstance().getAsp();
        SlimeWorld world;

        try {
            world = api.readVanillaWorld(new File("."), "island", CortexSkyblock.getInstance().getIslandLoader());
            api.saveWorld(world);
        } catch (InvalidWorldException | WorldLoadedException | WorldTooBigException | IOException | WorldAlreadyExistsException e) {
            throw new RuntimeException(e);
        }
    }
}
