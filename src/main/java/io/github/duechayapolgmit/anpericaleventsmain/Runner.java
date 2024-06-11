package io.github.duechayapolgmit.anpericaleventsmain;

import io.github.duechayapolgmit.anpericaleventsmain.chat.ChatManager;
import io.github.duechayapolgmit.anpericaleventsmain.chat.GameStateChangeChat;
import io.github.duechayapolgmit.anpericaleventsmain.gui.BossBarMain;
import io.github.duechayapolgmit.anpericaleventsmain.gui.ScoreboardMain;

import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import io.github.duechayapolgmit.anpericaleventsmain.type.ChatType;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.List;

public final class Runner extends JavaPlugin {

    private BukkitTask scoreboardTask;
    private BukkitTask bossbarTask;
    private BukkitTask bgBossBarTask;

    private BukkitTask timerTask;

    private List<BossBarMain> activeBossBars = new ArrayList<BossBarMain>();

    Time time;

    @Override
    public void onEnable() {
        time = new Time(120);

        BossBarMain statusBar = new BossBarMain("\uE001");
        activeBossBars.add(statusBar);
        BossBarMain timeBossBar = new BossBarMain(time);
        activeBossBars.add(timeBossBar);

        ChatManager.getInstance().sendMessage(ChatType.DEBUG, Component.text("Plugin initialised"));
        ChatManager.getInstance().sendMessage(ChatType.DEBUG, GameStateChangeChat.getMessage(GameState.PRE_GAME,GameState.IN_GAME));

        scoreboardTask = getServer().getScheduler().runTaskTimer(this, ScoreboardMain.getInstance(), 0, 20);
        bgBossBarTask = getServer().getScheduler().runTaskTimer(this, statusBar, 0, 4);
        bossbarTask = getServer().getScheduler().runTaskTimer(this, timeBossBar, 23, 18);

        timerTask = Bukkit.getServer().getScheduler().runTaskTimer(this, new Runnable() {
            @Override
            public void run() {
                time.decrement();
                timeBossBar.update();

                if (time.getRawTime() == 0) timerTask.cancel();
            }
        }, 20, 20);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        // Disable boss bars
        for (BossBarMain bar: activeBossBars){
            bar.remove();
            System.out.println(bar);
        }
        activeBossBars = new ArrayList<BossBarMain>();

        bgBossBarTask.cancel();
        bossbarTask.cancel();
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
