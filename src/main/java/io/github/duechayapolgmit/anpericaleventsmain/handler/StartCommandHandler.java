package io.github.duechayapolgmit.anpericaleventsmain.handler;

import io.github.duechayapolgmit.anpericaleventsmain.Runner;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBarManager;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.TimeBossBar;
import io.github.duechayapolgmit.anpericaleventsmain.state.StateManager;
import io.github.duechayapolgmit.anpericaleventsmain.task.TaskManager;
import io.github.duechayapolgmit.anpericaleventsmain.task.TimerTask;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class StartCommandHandler {

    private static BukkitScheduler scheduler = Bukkit.getScheduler();
    private StartCommandHandler(){}

    public static void execute(int time){
        Time startTime = new Time(time);
        TimeBossBar timeBossBar = new TimeBossBar(StateManager.getInstance().getGameState(), startTime);
        BossBarManager.addBossBar(timeBossBar);

        BukkitTask bossbarTask = scheduler.runTaskTimer(Runner.getPlugin(Runner.class), timeBossBar, 23, 18);
        TaskManager.addTask("boss-bar", bossbarTask);

        TimerTask.getInstance().startTask(scheduler, timeBossBar);
    }
}
