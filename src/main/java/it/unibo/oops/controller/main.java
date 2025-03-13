package it.unibo.oops.controller;

import it.unibo.oops.controller.gamestate.GameState;
import it.unibo.oops.view.DrawView;
import it.unibo.oops.view.DrawViewImpl;
import it.unibo.oops.view.GamePanel;

final class MainApp {

    private MainApp(final DrawView window) {
        window.changeGameState(GameState.PLAYSTATE); // EASILY CHANGE THE PANEL HERE
        new GameThread(new GamePanel(0, 0));
    }
    public static void main(final String[] args) {
        new MainApp(new DrawViewImpl(GameState.TITLESTATE));
    }
}
