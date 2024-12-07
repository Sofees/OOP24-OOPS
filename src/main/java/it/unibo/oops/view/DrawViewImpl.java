package it.unibo.oops.view;

import javax.swing.JFrame;

import it.unibo.oops.controller.gamestate.GameState;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * 
 */
public final class DrawViewImpl implements DrawView {
    private static final String FRAME_NAME = "OOP Survivors";
    private static final int PROPORTION = 3;

    private final JFrame frame = new JFrame(FRAME_NAME);
    private final Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    private final int sw = (int) d.getWidth();
    private final int sh = (int) d.getHeight();
    private GameState currentGameState = GameState.TITLESTATE;
    /**
     * 
     */
    public DrawViewImpl() {
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setContentPane(new GamePanel(sw / PROPORTION, sh / PROPORTION)); // Switch che sceglie il panel giusto
        this.frame.pack();
        this.frame.setLocationRelativeTo(null);
        this.start();
    }

    @Override
    public void start() {
        this.frame.setVisible(true);
    }

    @Override
    public void changeGameState(final GameState gameState) {
        this.currentGameState = gameState;
        switch (currentGameState) {
            case TITLESTATE -> setTitleState();
            case TITLEOPTIONSTATE, PAUSESTATE -> setOptionState();
            case PLAYSTATE -> setPlayState();
            default -> throw new IllegalArgumentException();
        }
    }
    private void setTitleState() {
        this.frame.setContentPane(new TitlePanel(sw / PROPORTION, sh / PROPORTION));
        this.frame.pack();
    }
    private void setOptionState() {  //GamePanel da sostituire con un OptionPanel
        this.frame.setContentPane(new GamePanel(sw / PROPORTION, sh / PROPORTION));
        this.frame.pack();
    }
    private void setPlayState() {
        this.frame.setContentPane(new GamePanel(sw / PROPORTION, sh / PROPORTION));
        this.frame.pack();
    }
    /**
     *  @return the current gameState.
     */
    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
