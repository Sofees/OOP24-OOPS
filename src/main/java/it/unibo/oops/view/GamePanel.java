package it.unibo.oops.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import it.unibo.oops.model.*;
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

    private Player player;
    private ItemManager itemManager;
    
    public GamePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.BLACK);
    }

    
    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setItemManager(ItemManager itemManager) {
        this.itemManager = itemManager;
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        itemManager.draw(g2d);
    }

}
