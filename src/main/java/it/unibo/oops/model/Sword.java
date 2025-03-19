package it.unibo.oops.model;
import java.awt.Color;
import java.awt.Graphics;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 * 
 */
@SuppressFBWarnings(value = {"EI2"}, 
justification = "To position the weapon, the player size and position are needed, "
        + "and while it's not necessary for the player to be externally mutable for this class, it has to be for others.")
public class Sword extends Weapon {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 30;
    private static final double DURATION = 30;
    private static final double COOLDOWN = 90;

    private double timer;
    private double cooldown;
    private boolean active;
    private final Player player;
    /**
     * @param player
     */
    public Sword(final Player player) {
        this.active = false;
        this.timer = DURATION;
        this.cooldown = COOLDOWN;
        this.player = player;
    }
    /**
     * Updates the sword.
     */
    @Override
    public void update() {
        if (active) {
            timer--;
            if (timer <= 0) {
                active = false;
                this.cooldown = COOLDOWN;
                this.timer = DURATION;
            }
        } else {
            if (cooldown <= 0) {
                this.active = true;
            } else {
                cooldown--;
            }
        }
    }
    /**
     * Draws the sword.
     * @param g
     */
    @Override
    public void draw(final Graphics g) {
        if (active) {
            g.setColor(Color.BLUE);
            int drawX = player.getX(), drawY = player.getY();
            switch (player.getDirection()) {
                case Direction.UP:
                    drawX = player.getX() + WIDTH * 2;
                    drawY = player.getY() - HEIGHT;
                    break;
                case Direction.RIGHT: 
                    drawX = WIDTH;
                    drawY = HEIGHT / 2;
                    break;
                case Direction.DOWN:
                    drawX = WIDTH / 2;
                    drawY = HEIGHT;
                    break;
                case Direction.LEFT:
                    drawX = WIDTH / 2;
                    drawY = HEIGHT / 2;
                    break;
                default:
                    break;
            }
            g.fillRect(drawX, drawY, WIDTH, HEIGHT);
        }
    }
}
