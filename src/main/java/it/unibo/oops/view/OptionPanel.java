package it.unibo.oops.view;

import javax.swing.*;
import java.awt.*;
//import java.awt.event.ActionListener;
import it.unibo.oops.controller.gamestate.GameState;
//import it.unibo.oops.view.DrawView;

public class OptionPanel extends MyPanel {
    @SuppressWarnings("unused") // TEMPORARY
    private static final double serialVersionUID = getSerialVersionUID();
    //private final DrawView drawView;

    /**
     * @param screenWidth
     * @param screenHeight
     */
    public OptionPanel(final int screenWidth, final int screenHeight, final DrawView drawView) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Settings", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        super.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton FullscreenButton = new JButton("Fullscreen");
        JButton screenSizeButton = new JButton("Screen Size");
        JButton volumeButton = new JButton("Volume");
        JButton sfxButton = new JButton("SFX");
        JButton returnButton = new JButton("Return");

        /* 
        newGameButton.addActionListener(e -> drawView.changeGameState(GameState.PLAYSTATE));
        //loadGameButton.addActionListener(e -> drawView.changeGameState(GameState.TITLEOPTIONSTATE));
        settingsButton.addActionListener(e -> drawView.changeGameState(GameState.TESTSTATE));
        quitButton.addActionListener(e -> System.exit(0));
        */

        returnButton.addActionListener(e -> drawView.changeGameState(GameState.TITLESTATE));

        buttonPanel.add(FullscreenButton);
        buttonPanel.add(screenSizeButton);
        buttonPanel.add(volumeButton);
        buttonPanel.add(sfxButton);
        buttonPanel.add(returnButton);

        super.add(buttonPanel, BorderLayout.CENTER);
    }
}
