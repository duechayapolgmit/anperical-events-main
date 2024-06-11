package io.github.duechayapolgmit.anpericaleventsmain.bossbar;

import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class BossBar implements Runnable {

    protected net.kyori.adventure.bossbar.BossBar bar = null;

    protected GameState gameState;

    protected final Key FONT = Key.key("cgn:default_shift_up");
    protected final Key BG = Key.key("cgn:boss_bar");

    public BossBar(String text) {
        TextComponent title = (TextComponent) Component.text(text).font(BG).color(TextColor.fromCSSHexString("#4e5c24"));

        bar = net.kyori.adventure.bossbar.BossBar.bossBar(title, 1, net.kyori.adventure.bossbar.BossBar.Color.WHITE, net.kyori.adventure.bossbar.BossBar.Overlay.PROGRESS);

    }

    public BossBar(){}

    public void remove(){
        for (Player player: Bukkit.getOnlinePlayers()){
            player.hideBossBar(bar);
        }
    }

    @Override
    public void run() {
        for (Player player: Bukkit.getOnlinePlayers()){
            player.showBossBar(bar);
        }
    }

}
