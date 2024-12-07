package it.unibo.oops.view;

import java.awt.Color;
import java.awt.Dimension;

import it.unibo.oops.controller.GameThread;
/**
 * 
 */
public class GamePanel extends MyPanel { 
    @SuppressWarnings("unused") // TEMPORARY
    private static final double serialVersionUID = getSerialVersionUID();
    /**
     * @param screenWidth
     * @param screenHeight
     */
    public GamePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.BLACK);
        new GameThread();
    }
}
