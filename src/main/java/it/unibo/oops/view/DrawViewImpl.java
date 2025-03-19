package it.unibo.oops.view;

import java.awt.event.KeyListener;
import it.unibo.oops.controller.gamestate.GameState;
import it.unibo.oops.model.EnemyManager;
import it.unibo.oops.model.ExperienceManager;
import it.unibo.oops.model.Player;

import it.unibo.oops.model.WeaponManager;

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
    private final TitlePanel titlePanel;
    private final OptionPanel optionPanel;
    private final GamePanel gamePanel;
    private final TestPanel testPanel;
    /**
     * @param gameState
     * @param player
     * @param enemyManager
     * @param weaponManager
     * @param experienceManager
     */
    public DrawViewImpl(final GameState gameState, final Player player, final EnemyManager enemyManager, 
        final WeaponManager weaponManager, final ExperienceManager experienceManager) {
        this.titlePanel = new TitlePanel(this.sw / PROPORTION, this.sh / PROPORTION, this);
        this.optionPanel = new OptionPanel(this.sw / PROPORTION, this.sh / PROPORTION, this);
        this.gamePanel = new GamePanel(this.sw / PROPORTION, this.sh / PROPORTION, 
        player, enemyManager, weaponManager, experienceManager);
        testPanel = new TestPanel(this.sw / PROPORTION, this.sh / PROPORTION);
        this.changeGameState(gameState);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setLocationRelativeTo(null);
        this.start();
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
                    this.currentPanel = titlePanel;
                }
                case TITLEOPTIONSTATE, PAUSESTATE -> {
                    this.currentPanel = optionPanel;
                }
                case PLAYSTATE -> {
                    this.currentPanel = gamePanel;
                }
                case TESTSTATE -> {
                    this.currentPanel = testPanel;
                }
                default -> throw new IllegalArgumentException();
            }
            this.setState();
        }
    }
    /**
    *  Sets the current panel on the screen.
    */
    private void setState() {
        SwingUtilities.invokeLater(() -> {
            this.frame.setContentPane(this.currentPanel);
            this.frame.pack();
        });
    }
    @Override
    public GameState getCurrentGameState() {
        return this.currentGameState;
    }
    @Override
    public void repaint() {
        this.currentPanel.repaint();
    }
    // /**
    //  *  @return the current Panel.
    //  */
    // private MyPanel getCurrentPanel() {
    //     return this.currentPanel;
    // }
    /**
     * Adds a key listener to the frame.
     * 
     * @param listener the key listener to add
     */
    public void addKeyListener(final KeyListener listener) {
        frame.addKeyListener(listener);
    }

    /**
     * Sets whether the frame is focusable.
     * 
     * @param focusable true if the frame should be focusable
     */
    public void setFocusable(final boolean focusable) {
        frame.setFocusable(focusable);
        frame.requestFocusInWindow();
    }
}
