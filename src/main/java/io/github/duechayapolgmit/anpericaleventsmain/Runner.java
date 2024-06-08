package io.github.duechayapolgmit.anpericaleventsmain;

import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBarMain;
import io.github.duechayapolgmit.anpericaleventsmain.scoreboard.ScoreboardMain;

import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Runner extends JavaPlugin {

    private BukkitTask scoreboardTask;
    private BukkitTask bossbarTask;

    private BukkitTask timerTask;

    Time time;

    @Override
    public void onEnable() {
        time = new Time(60);
        BossBarMain timeBossBar = new BossBarMain(time);

        scoreboardTask = getServer().getScheduler().runTaskTimer(this, ScoreboardMain.getInstance(), 0, 20);
        bossbarTask = getServer().getScheduler().runTaskTimer(this, timeBossBar, 20, 20);

        timerTask = Bukkit.getServer().getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                time.decrement();
                timeBossBar.update();
                System.out.println(time.getTime());

                if (time.getRawTime() == 0) timerTask.cancel();
            }
        }, 20, 20);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage(Component.text(event.getPlayer().getName() + "joined the game."));
        /*
        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
            public void run() {
                event.getPlayer().setScoreboard(ScoreboardMain.getBoard());
            }
        },0, 20 * 10);*/
    }
}
