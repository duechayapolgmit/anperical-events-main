package io.github.duechayapolgmit.anpericaleventsmain.scoreboard;

import net.kyori.adventure.key.Key;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.format.TextColor;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.awt.*;

public class ScoreboardMain implements Runnable  {

    private final static ScoreboardMain instance = new ScoreboardMain();

    private ScoreboardManager manager;
    private Scoreboard board;
    private Objective objective;

    private ScoreboardMain() {
        manager = Bukkit.getScoreboardManager();
        board = manager.getNewScoreboard();

        Key font = Key.key("cgn:default");

        TextComponent title = (TextComponent) Component.text("Anperical Events Test 1")
                .color(TextColor.color(0x00ffff))
                .font(font);

        objective = board.registerNewObjective("anperical-test", Criteria.DUMMY, title);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

    }

    @Override
    public void run() {
        for (Player player: Bukkit.getOnlinePlayers()){
            createNewScoreboard(player);
            //ScoreboardTeam.addEntry(player);
        }
    }

    private void createNewScoreboard(Player player) {
        player.setScoreboard(board);
    }

    public static ScoreboardMain getInstance(){
        return instance;
    }

    public Objective getObjective() { return objective; }

    public Scoreboard getBoard() { return board; }

}
