package it.unibo.oops.model;

import java.awt.Color;
import java.awt.Graphics;
/**
*
*/
public class ExperienceOrb {

    private int x, y;
    private int xp;
    /**
     * Updates the ExpOrb.
     */

    public ExperienceOrb (int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.xp = amount;
    }

    public int getXP() {
        return this.xp;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Draws the ExpOrb.
     */
    public void draw(Graphics g) {
        g.setColor(Color.PINK);
        g.fillRect(x, y, 10, 10);
    }

}
