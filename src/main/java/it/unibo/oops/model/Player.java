package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * 
 */
public class Player extends Entity {

    private String direction;
    /**
     * @param x
     * @param y
     * @param maxHealth
     * @param health
     * @param speed
     * @param size
     */
    public Player(final int x, final int y, final int maxHealth, final int health, final int speed, final int size) {
        super(x, y, maxHealth, health, speed, size);
        this.direction = "UP";
    }
    /**
     * @return the facing direction of the player.
     */
    public String getDirection() {
        return direction;
    }
    /**
     * Sets the facing direction of the player.
     * @param direction
     */
    public void setDirection(final String direction) {
        this.direction = direction;
    }
    /**
     * Updates the direction of the player.
     */
    @Override
    public void update() {
       switch (direction) {
            case "UP":
                //setY(getY() - getSpeed());
                break;
            case "DOWN":
                //setY(getY() + getSpeed());
                break;
            case "LEFT":
                //setX(getX() - getSpeed());
                break;
            case "RIGHT":
                //setX(getX() + getSpeed());
                break;
            default:
                throw new IllegalArgumentException();
       }
    }
    /**
     * Draws the player.
     * @param g
     */
    @Override
    public void draw(final Graphics2D g) {
        g.setColor(Color.GREEN);    //colore rettangolo
        g.fillRect(getX(), getY(), getSize(), getSize());
    }
}
