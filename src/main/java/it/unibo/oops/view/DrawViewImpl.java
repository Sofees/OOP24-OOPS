package it.unibo.oops.view;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import it.unibo.oops.controller.GameThread;
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
     * @param gameState
     */
    public DrawViewImpl(final GameState gameState) {
        SwingUtilities.invokeLater(() -> {
            this.changeGameState(gameState);
            this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.frame.setLocationRelativeTo(null);
            this.start();
        });
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setVisible(true);
        });
    }

    @Override
    public void changeGameState(final GameState gameState) {
        if (currentGameState != gameState) {
            this.currentGameState = gameState;
            switch (currentGameState) {
                case TITLESTATE -> setTitleState();
                case TITLEOPTIONSTATE, PAUSESTATE -> setOptionState();
                case PLAYSTATE -> setPlayState();
                case TESTSTATE -> setTestState();
                default -> throw new IllegalArgumentException();
            }
        }
    }
    private void setTitleState() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setContentPane(new TitlePanel(sw / PROPORTION, sh / PROPORTION, this));
            this.frame.pack();
        });
    }
    private void setOptionState() {
        SwingUtilities.invokeLater(() -> {
            //GamePanel da sostituire con un OptionPanel
            this.frame.setContentPane(new OptionPanel(sw / PROPORTION, sh / PROPORTION, this));
            this.frame.pack();
        });
    }
    private void setPlayState() {
        SwingUtilities.invokeLater(() -> {
            GamePanel gamePanel = new GamePanel(sw / PROPORTION, sh / PROPORTION);
            new GameThread(gamePanel); 
            this.frame.setContentPane(gamePanel);
            this.frame.pack();
        });
    }
    private void setTestState() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setContentPane(new TestPanel(sw / PROPORTION, sh / PROPORTION));
            this.frame.pack();
        });
    }
    /**
     *  @return the current gameState.
     */
    public GameState getCurrentGameState() {
        return currentGameState;
    }
}
