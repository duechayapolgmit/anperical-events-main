package io.github.duechayapolgmit.anpericaleventsmain;

import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBarManager;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.TimeBossBar;
import io.github.duechayapolgmit.anpericaleventsmain.chat.ChatManager;
import io.github.duechayapolgmit.anpericaleventsmain.chat.GameStateChangeChat;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBar;
import io.github.duechayapolgmit.anpericaleventsmain.command.StartCommand;
import io.github.duechayapolgmit.anpericaleventsmain.gui.ScoreboardMain;

import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import io.github.duechayapolgmit.anpericaleventsmain.state.StateManager;
import io.github.duechayapolgmit.anpericaleventsmain.task.TaskManager;
import io.github.duechayapolgmit.anpericaleventsmain.task.TimerTask;
import io.github.duechayapolgmit.anpericaleventsmain.type.ChatType;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Debug;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import io.papermc.paper.command.brigadier.Commands;
import io.papermc.paper.plugin.bootstrap.BootstrapContext;
import io.papermc.paper.plugin.lifecycle.event.LifecycleEventManager;
import io.papermc.paper.plugin.lifecycle.event.types.LifecycleEvents;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public final class Runner extends JavaPlugin {

    BukkitScheduler scheduler = Bukkit.getServer().getScheduler();

    private BukkitTask scoreboardTask;
    private BukkitTask bossbarTask;
    private BukkitTask bgBossBarTask;
    private BukkitTask timerTask;

    private GameState currentState = GameState.PRE_GAME;

    Time time;

    @Override
    public void onEnable() {

        BossBar statusBar = new BossBar("\uE001");
        BossBarManager.addBossBar(statusBar);
        Debug.log(Component.text("Plugin initialised").color(TextColor.color(0xFFFFFF)));

        scoreboardTask = scheduler.runTaskTimer(this, ScoreboardMain.getInstance(), 0, 20);
        bgBossBarTask = scheduler.runTaskTimer(this, statusBar, 0, 4);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Disable boss bars
        for (BossBar bar: BossBarManager.getBossBars()){
            bar.remove();
            System.out.println(bar);
        }
        // Remove all active boss bars
        BossBarManager.getBossBars().clear();

        bgBossBarTask.cancel();
        TaskManager.getTask("boss-bar").cancel();
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
