package io.github.duechayapolgmit.anpericaleventsmain;

import io.github.duechayapolgmit.anpericaleventsmain.command.StartCommand;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Debug;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.bootstrap.PluginBootstrap;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import org.jetbrains.annotations.NotNull;

public class Bootstrap implements PluginBootstrap {
    @Override
    public void bootstrap(@NotNull BootstrapContext context) {
        // Register commands
        LifecycleEventManager<BootstrapContext> manager = context.getLifecycleManager();
        manager.registerEventHandler(LifecycleEvents.COMMANDS, event -> {
            final Commands commands = event.registrar();
            commands.register("start", "starts the game with either a specified time or not (default is 30s)", new StartCommand());
            System.out.println("[BOOTSTRAP] Commands initialised");
        });

        System.out.println("[BOOTSTRAP] Boostrap completed");
    }
}
