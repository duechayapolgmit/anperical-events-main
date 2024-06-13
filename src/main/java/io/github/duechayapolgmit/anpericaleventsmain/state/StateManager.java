package io.github.duechayapolgmit.anpericaleventsmain.state;

public class StateManager {

    private static StateManager instance = new StateManager();
    private GameState gameState;

    private StateManager(){
        this.gameState = GameState.PRE_GAME;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public static StateManager getInstance() {
        return instance;
    }
}
