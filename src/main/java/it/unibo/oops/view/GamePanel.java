package it.unibo.oops.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
        super();
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.BLACK);
    }
    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        this.getPlayer().draw(g2d);
        this.getEnemyManager().drawWave(g2d);
        this.getEnemy().draw(g2d);
        this.getWeaponManager().draw(g2d);
    }

}
