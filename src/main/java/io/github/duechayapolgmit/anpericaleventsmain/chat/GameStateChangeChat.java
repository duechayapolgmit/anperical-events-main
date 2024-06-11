package io.github.duechayapolgmit.anpericaleventsmain.chat;

import io.github.duechayapolgmit.anpericaleventsmain.state.GameState;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

public class GameStateChangeChat{

    public static TextComponent getMessage(GameState oldState, GameState newState){
        TextComponent msg = Component.text("Game state has changed from ")
                .color(TextColor.color(0xFFFFFF))
                .append(Component.text(oldState.toString())
                        .color(TextColor.color(0xFFFF55)))
                .append(Component.text(" to ")
                        .color(TextColor.color(0xFFFFFF)))
                .append(Component.text(newState.toString())
                        .color(TextColor.color(0xFFFF55)));

        return msg;
    }
}
