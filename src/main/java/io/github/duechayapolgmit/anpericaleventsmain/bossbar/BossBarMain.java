package io.github.duechayapolgmit.anpericaleventsmain.bossbar;

import io.github.duechayapolgmit.anpericaleventsmain.bossbar.BossBarMain;
import io.github.duechayapolgmit.anpericaleventsmain.scoreboard.ScoreboardMain;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.bossbar.BossBar;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BossBarMain implements Runnable {

    private BossBar bar;

    private Time time;

    private final Key FONT = Key.key("cgn:default_shift_up");
    private final Key BG = Key.key("cgn:boss_bar");

    public BossBarMain(String text) {

        TextComponent title = (TextComponent) Component.text(text).font(BG).color(TextColor.fromCSSHexString("#4e5c24"));

        bar = BossBar.bossBar(title, 1, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);

    }

    public BossBarMain(Time time) {
        this.time = time;

        TextComponent title = (TextComponent) Component.text(time.getTime()).font(FONT);

        bar = BossBar.bossBar(title, 1, BossBar.Color.WHITE, BossBar.Overlay.PROGRESS);
    }

    // can delegate
    public void update(){
        Key font = Key.key("cgn:default");

        TextComponent title = (TextComponent) Component.text(this.time.getTime()).font(FONT);

        bar = bar.name(title);
    }

    @Override
    public void run() {
        for (Player player: Bukkit.getOnlinePlayers()){
            player.showBossBar(bar);
        }
    }

}
