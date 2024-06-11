package io.github.duechayapolgmit.anpericaleventsmain.state;

public enum GameState {
    PRE_GAME ("Starting in: "),
    IN_GAME (""),
    POST_GAME ("");

    private String prefix;

    GameState(String prefix) {
        this.prefix = prefix;
    }

    GameState(String prefix, String altPrefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }

}
