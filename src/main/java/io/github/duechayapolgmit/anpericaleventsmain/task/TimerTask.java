package io.github.duechayapolgmit.anpericaleventsmain.task;

import io.github.duechayapolgmit.anpericaleventsmain.Runner;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBar;
import io.github.duechayapolgmit.anpericaleventsmain.bossbar.TimeBossBar;
import io.github.duechayapolgmit.anpericaleventsmain.chat.ChatManager;
import io.github.duechayapolgmit.anpericaleventsmain.chat.GameStateChangeChat;
import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import io.github.duechayapolgmit.anpericaleventsmain.state.StateManager;
import io.github.duechayapolgmit.anpericaleventsmain.type.ChatType;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Debug;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import org.bukkit.scheduler.BukkitScheduler;
import org.bukkit.scheduler.BukkitTask;

public class TimerTask {
    private static TimerTask instance = new TimerTask();
    private StateManager sm = StateManager.getInstance();
    private BukkitTask task;

    public void startTask(BukkitScheduler scheduler, TimeBossBar bar){
        task = scheduler.runTaskTimer(Runner.getPlugin(Runner.class), new Runnable() {
            @Override
            public void run() {
                // Get current state
                GameState state = sm.getGameState();

                if (bar.getTime() == null) {
                    bar.update();
                    task.cancel();
                } else bar.getTime().decrement();

                if (bar.getTime().getRawTime() == 0) {
                    if (state == GameState.PRE_GAME) {
                        Debug.log(GameStateChangeChat.getMessage(GameState.PRE_GAME,GameState.IN_GAME));
                        bar.setTime(new Time(10));
                        bar.changeState(GameState.IN_GAME);
                        sm.setGameState(GameState.IN_GAME);
                    }
                    else if (state == GameState.IN_GAME) {
                        Debug.log(GameStateChangeChat.getMessage(GameState.IN_GAME,GameState.POST_GAME));
                        sm.setGameState(GameState.POST_GAME);
                        bar.setTime(null);
                        bar.changeState(GameState.POST_GAME);
                    }
                }
                bar.update();
            }
        }, 20, 20);
    }

    public static TimerTask getInstance() {
        return instance;
    }
}
