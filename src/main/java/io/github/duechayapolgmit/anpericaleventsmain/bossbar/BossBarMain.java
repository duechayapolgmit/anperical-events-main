package io.github.duechayapolgmit.anpericaleventsmain.bossbar;

import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBarMain;
import io.github.duechayapolgmit.anpericaleventsmain.scoreboard.ScoreboardMain;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BossBarMain implements Runnable {

    private BossBar bar;

    private Time time;

    public BossBarMain(String text) {
        Key font = Key.key("cgn:default");

        TextComponent title = (TextComponent) Component.text(text)
                .font(font);

        bar = BossBar.bossBar(title, 1, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);

    }

    public BossBarMain(Time time) {
        this.time = time;
        Key font = Key.key("cgn:default");

        TextComponent title = (TextComponent) Component.text(time.getTime())
                .font(font);

        bar = BossBar.bossBar(title, 1, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);
    }

    // can delegate
    public void update(){
        Key font = Key.key("cgn:default");

        TextComponent title = (TextComponent) Component.text(this.time.getTime())
                .font(font);

        bar = bar.name(title);
    }

    @Override
    public void run() {
        for (Player player: Bukkit.getOnlinePlayers()){
            player.showBossBar(bar);
        }
    }

}
