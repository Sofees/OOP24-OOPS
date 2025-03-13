package it.unibo.oops.view;

import it.unibo.oops.controller.gamestate.GameState;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
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
    private GameState currentGameState;
    private MyPanel currentPanel;
    /**
     * @param gameState
     */
    public DrawViewImpl(final GameState gameState) {
        try {
            SwingUtilities.invokeAndWait(() -> {
                this.changeGameState(gameState);
                this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.frame.setLocationRelativeTo(null);
                this.start();
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
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
                case TITLESTATE -> {
                    this.currentPanel = new TitlePanel(this.sw / PROPORTION, this.sh / PROPORTION, this);
                }
                case TITLEOPTIONSTATE, PAUSESTATE -> {
                    this.currentPanel = new OptionPanel(this.sw / PROPORTION, this.sh / PROPORTION, this);
                }
                case PLAYSTATE -> {
                    this.currentPanel = new GamePanel(this.sw / PROPORTION, this.sh / PROPORTION);
                }
                case TESTSTATE -> {
                    this.currentPanel = new TestPanel(this.sw / PROPORTION, this.sh / PROPORTION);
                }
                default -> throw new IllegalArgumentException();
            }
            this.setState();
        }
    }
    
    private void setState() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setContentPane(this.currentPanel);
            this.frame.pack();
        });
    }
    /**
     *  @return the current gameState.
     */
    public GameState getCurrentGameState() {
        return this.currentGameState;
    }
    /**
     *  @return the current Panel.
     */
    public MyPanel getCurrentPanel() {
        return this.currentPanel;
    }
} 

