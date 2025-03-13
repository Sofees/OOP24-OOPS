package it.unibo.oops.model;

import java.awt.Graphics;
/**
*
*/
public abstract class ExperienceOrb extends Item {
    /**
     * Updates the ExpOrb.
     */
    public abstract void update();
    /**
     * Draws the ExpOrb.
     */
    public abstract void draw(Graphics g);
}
