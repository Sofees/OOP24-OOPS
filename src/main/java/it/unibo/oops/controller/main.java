package it.unibo.oops.controller;

import it.unibo.oops.controller.gamestate.GameState;
import it.unibo.oops.view.DrawViewImpl;

final class MainApp {

    private MainApp(final DrawViewImpl window) {
        new GameThread(window);
    }
    public static void main(final String[] args) {
        new MainApp(new DrawViewImpl(GameState.TITLESTATE));
    }
}
