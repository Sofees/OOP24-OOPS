package it.unibo.oops.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import it.unibo.oops.model.ItemManager;
import it.unibo.oops.model.Player;
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

    private Player player = new Player(0,0 , 100, 5);
    private ItemManager itemManager = new ItemManager();;
    /**
     *
     */
    public GamePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.RED);
    }
    /**
     * Sets the current player.
     */
    public void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * Sets the current itemManager
     */
    public void setItemManager(final ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        itemManager.draw(g2d);
    }

}
