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
    private Player player;
    private ItemManager itemManager;
    /**
     * @param screenWidth
     * @param screenHeight
     */
    public GamePanel(final int screenWidth, final int screenHeight) {
        super();
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.RED);
    }
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.getPlayer().draw(g2d);
        this.getItemManager().draw(g2d);
    }

}
