package io.github.duechayapolgmit.anpericaleventsmain.utils;

import io.github.duechayapolgmit.anpericaleventsmain.chat.ChatManager;
import io.github.duechayapolgmit.anpericaleventsmain.type.ChatType;
import net.kyori.adventure.text.TextComponent;

public class Debug {
    private static ChatManager cm = ChatManager.getInstance();

    private Debug(){}

    public static void log(TextComponent msg) {
        cm.sendMessage(ChatType.DEBUG, msg);
    }

}
