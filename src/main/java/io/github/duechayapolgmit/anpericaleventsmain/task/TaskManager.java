package io.github.duechayapolgmit.anpericaleventsmain.task;

import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBar;
import org.bukkit.scheduler.BukkitTask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    private static Map<String, BukkitTask> tasks = new HashMap<String, BukkitTask>();

    public static void addTask(String key, BukkitTask task){
        tasks.put(key, task);
    }

    public static void removeBossBar(String key){
        tasks.remove(key);
    }

    public static BukkitTask getTask(String key){
        return tasks.get(key);
    }
}
