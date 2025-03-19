package it.unibo.oops.controller;

import javax.swing.SwingUtilities;

final class MainApp {

    private MainApp() {
        SwingUtilities.invokeLater(() -> {
            new GameThreadImpl();
        });
    }
    public static void main(final String[] args) {
        new MainApp();
    }
}
