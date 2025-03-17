package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
/**
 * 
 */
public abstract class Enemy extends Entity {
    //TEMPORARLY FINAL and STATIC
    private static final String DIRECTION = "LEFT";
    private boolean isPositioned;
    /**
     * @param x
     * @param y
     * @param maxHealth
     * @param health
     * @param speed
     * @param size
     */
    public Enemy(final int x, final int y, final int maxHealth, final int health, final int speed, final int size) {
        super(x, y, maxHealth, health, speed, size);
    }
    /**
     * @return if the enemy has been positioned.
     */
    public boolean isPositioned() {
        return isPositioned;
    }
    /**
     * @param isPositioned
     */
    public void setPosition(final boolean isPositioned) {
        this.isPositioned = isPositioned;
    }
    /**
     * Draws current enemy.
     */
    @Override
    public void draw(final Graphics2D g2) {
        try {
            final BufferedImage image = 
            ImageIO.read(this.getClass().getResource("./resources/Monster/" + this.getClass().getSimpleName() + ".png"));
            g2.drawImage(image, getX(), getY(), null);
        } catch (IOException e) {
            Logger.getLogger(this.getClass().getName()).
            log(Level.SEVERE, "An InterruptedException occurred: ", e);
        }
    }
    /**
     * Updates current enemy.
     */
    @Override
    public void update() {
        switch (DIRECTION) {
            case "UP" -> setY(getY() - getSpeed());
            case "DOWN" -> setY(getY() + getSpeed());
            case "LEFT" -> setX(getX() - getSpeed());
            case "RIGHT" -> setX(getX() + getSpeed());
            default -> throw new IllegalArgumentException();
       }
    }
}
