package io.github.duechayapolgmit.anpericaleventsmain.bossbar;

import java.util.ArrayList;
import java.util.List;

public class BossBarManager {
    private static List<BossBar> activeBossBars = new ArrayList<BossBar>();

    public static void addBossBar(BossBar bar){
        activeBossBars.add(bar);
    }

    public static void removeBossBar(BossBar bar){
        activeBossBars.remove(bar);
    }

    public static List<BossBar> getBossBars(){
        return activeBossBars;
    }
}
