package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.Color;

/**
 * 
 */
public class Player extends Entity {
    private Direction direction;
    private int xp;
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
        this.direction = Direction.NONE;
    }
    /**
     * @return the facing direction of the player.
     */
    public Direction getDirection() {
        return this.direction;
    }
    /**
     * @return the current experience value of the player.
     */
    public int getXP() {
        return this.xp;
    }
    /**
     * Sets the facing direction of the player.
     * @param direction
     */
    public void setDirection(final Direction direction) {
        this.direction = direction;
    }
    /**
     * Adds to the player experience count.
     * @param xp
     */
    public void addXp(final int xp) {
        this.xp += xp;
    }
    /**
     * Updates the direction of the player.
     */
    @Override
    public void update() {
        final int speed = getSpeed(); // Declare speed as final
        int dx = 0;
        int dy = 0;
        boolean diagonal = false;

        switch (direction) {
            case UP:
                dy = -speed;
                break;
            case DOWN:
                dy = speed;
                break;
            case LEFT:
                dx = -speed;
                break;
            case RIGHT:
                dx = speed;
                break;
            case UPLEFT:
                dx = -speed;
                dy = -speed;
                diagonal = true;
                break;
            case UPRIGHT:
                dx = speed;
                dy = -speed;
                diagonal = true;
                break;
            case DOWNLEFT:
                dx = -speed;
                dy = speed;
                diagonal = true;
                break;
            case DOWNRIGHT:
                dx = speed;
                dy = speed;
                diagonal = true;
                break;
            case NONE:
                return;
            default:
                throw new IllegalArgumentException();
        }

        if (diagonal) {
            dx /= Math.sqrt(2);
            dy /= Math.sqrt(2);
        }

        setX(getX() + dx);
        setY(getY() + dy);
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
