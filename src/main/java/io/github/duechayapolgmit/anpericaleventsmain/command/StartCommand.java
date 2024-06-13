package io.github.duechayapolgmit.anpericaleventsmain.command;

import io.github.duechayapolgmit.anpericaleventsmain.handler.StartCommandHandler;
import io.papermc.paper.command.brigadier.BasicCommand;
import io.papermc.paper.command.brigadier.CommandSourceStack;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements BasicCommand {

    @Override
    public void execute(@NotNull CommandSourceStack commandSourceStack, @NotNull String[] args) {
        int time = 0;

        switch (args.length) {
            case 0:
                time = 30;
                break;
            case 1:
                time = Integer.parseInt(args[0]);
                break;
            default:
                return;
        }

        // Setup for start
        StartCommandHandler.execute(time);
    }

}
