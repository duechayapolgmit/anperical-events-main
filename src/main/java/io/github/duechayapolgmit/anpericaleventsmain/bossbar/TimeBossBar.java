package io.github.duechayapolgmit.anpericaleventsmain.bossbar;

import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import io.github.duechayapolgmit.anpericaleventsmain.utils.Time;
import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;

public class TimeBossBar extends BossBar {

    private Time time;
    private GameState gameState;

    public TimeBossBar(GameState gameState, Time time) {
        super();
        this.time = time;
        this.gameState = gameState;

        update();
    }

    public void update(){
        Key font = Key.key("cgn:default");

        String timeTitle;
        if (this.time == null) timeTitle = "";
        else timeTitle = this.time.getTime();

        TextComponent title = (TextComponent) Component.text(this.gameState.getPrefix())
                .append(Component.text(timeTitle))
                .font(FONT);

        if (bar == null) bar = net.kyori.adventure.bossbar.BossBar.bossBar(title, 1, net.kyori.adventure.bossbar.BossBar.Color.WHITE, net.kyori.adventure.bossbar.BossBar.Overlay.PROGRESS);
        else bar = bar.name(title);

    }

    public void setTime(Time time){
        this.time = time;
    }

    public Time getTime(){
        return this.time;
    }

    public void changeState(GameState gameState){
        this.gameState = gameState;
    }
}
