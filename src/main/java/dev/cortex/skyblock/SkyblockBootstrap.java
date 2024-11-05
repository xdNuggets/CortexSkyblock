package dev.cortex.skyblock;

import dev.cortex.skyblock.command.ImportIslandCommand;
import dev.cortex.skyblock.command.StupidFuckingCommand;
import dev.cortex.skyblock.command.TpWorldCommand;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;

public class SkyblockBootstrap implements PluginBootstrap {

    @Override
    public void bootstrap(BootstrapContext context) {
        LifecycleEventManager<BootstrapContext> manager = context.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register("import", new ImportIslandCommand());
            commands.register("worldtp", new TpWorldCommand());
            commands.register("create", new StupidFuckingCommand());
        });
    }
}
