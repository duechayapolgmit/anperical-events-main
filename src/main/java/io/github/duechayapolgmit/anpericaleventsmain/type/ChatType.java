package io.github.duechayapolgmit.anpericaleventsmain.type;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

public enum ChatType {
    DEBUG (Component.text("[DEBUG]").color(TextColor.color(0xFFFF55))),
    ANNOUNCEMENT (Component.text("[ANNOUNCE]").color(TextColor.color(0x00ffff)));

    private TextComponent prefix;

    ChatType(TextComponent prefix){
        this.prefix = prefix;
    }

    public TextComponent getPrefix() {
        return prefix;
    }
}
