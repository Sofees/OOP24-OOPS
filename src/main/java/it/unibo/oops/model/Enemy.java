package it.unibo.oops.model;

import java.awt.Color;
import java.awt.Graphics2D;
/**
 * 
 */
public class Enemy extends Entity {
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
        g2.setColor(Color.RED);
        g2.fillOval(getX(), getY(), getSize(), getSize());
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
