package io.github.duechayapolgmit.anpericaleventsmain.chat;

import io.github.duechayapolgmit.anpericaleventsmain.type.ChatType;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ChatManager {
    private final static ChatManager instance = new ChatManager();

    private ChatManager(){}

    public void sendMessage(ChatType type, TextComponent message) {

        TextComponent msg = type.getPrefix().append(Component.text(" ")).append(message);

        // Currently set to send to all players - will do permissions later
        Bukkit.getServer().sendMessage(msg);
        // Currently set to send to all players - will do permissions later
        // (Player player: Bukkit.getOnlinePlayers()){
        //    player.sendMessage(message);
        //}
    }

    public static ChatManager getInstance() {
        return instance;
    }
}
