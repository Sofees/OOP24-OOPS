package it.unibo.oops.view;

import javax.swing.*;
import java.awt.*;
import it.unibo.oops.controller.gamestate.GameState;

public class TitlePanel extends MyPanel {
    @SuppressWarnings("unused") // TEMPORARY
    private static final double serialVersionUID = getSerialVersionUID();
    private final DrawView drawView;

    /**
     * @param screenWidth
     * @param screenHeight
     * @param drawView to handle game state changes
     */
    public TitlePanel(final int screenWidth, final int screenHeight, final DrawView drawView) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setLayout(new BorderLayout());
        this.drawView = drawView;

        JLabel titleLabel = new JLabel("OOP Survivors", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        super.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton settingsButton = new JButton("Settings");
        JButton quitButton = new JButton("Quit");

        newGameButton.addActionListener(e -> drawView.changeGameState(GameState.PLAYSTATE));
        settingsButton.addActionListener(e -> drawView.changeGameState(GameState.TITLEOPTIONSTATE));
        quitButton.addActionListener(e -> System.exit(0));

        buttonPanel.add(newGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(quitButton);

        super.add(buttonPanel, BorderLayout.CENTER);
    }
}
