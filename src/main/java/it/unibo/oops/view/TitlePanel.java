package it.unibo.oops.view;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends MyPanel {
    @SuppressWarnings("unused") // TEMPORARY
    private static final double serialVersionUID = getSerialVersionUID();
    /**
     * @param screenWidth
     * @param screenHeight
     */
    public TitlePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Game Title", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        super.add(titleLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(4, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton newGameButton = new JButton("New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton settingsButton = new JButton("Settings");
        JButton quiButton = new JButton("Quit");
        
        buttonPanel.add(newGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(settingsButton);
        buttonPanel.add(quiButton);

        super.add(buttonPanel, BorderLayout.CENTER);
    }
}
