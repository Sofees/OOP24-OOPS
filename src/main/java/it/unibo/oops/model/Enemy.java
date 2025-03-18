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
    private Direction direction;
    private boolean isPositioned;
    private final Player player;
    /**
     * @param x
     * @param y
     * @param maxHealth
     * @param health
     * @param speed
     * @param size
     */
    public Enemy(final int x, final int y, final int maxHealth, final int health, final int speed, final int size, final Player player) {
        super(x, y, maxHealth, health, speed, size);
        this.player = player;
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
        if(player.getX() < this.getX()) {
            if(player.getY() < this.getY()) {
                direction = Direction.UP;
            } else {
                direction = Direction.LEFT;
            }
        } else {
            if(player.getY() < this.getY()) {
                direction = Direction.RIGHT;
            }
            direction = Direction.DOWN;
        }
        switch (direction) {
            case Direction.UP -> setY(getY() - getSpeed());
            case Direction.DOWN -> setY(getY() + getSpeed());
            case Direction.LEFT -> setX(getX() - getSpeed());
            case Direction.RIGHT -> setX(getX() + getSpeed());
            default -> throw new IllegalArgumentException();
       }
    }
}
