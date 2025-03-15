package it.unibo.oops.model;

import java.awt.Color;
import java.awt.Graphics2D;
/*
 * 
 */
public class Enemy extends Entity {

    private final Player player;
    private boolean isPositioned = false;
    private String direction = "LEFT";
    
    public Enemy(Player player, int x, int y, int maxHealth, int health, int speed, int size) {
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
    public void setPosition(boolean isPositioned) {
        this.isPositioned = isPositioned;
    }
    /**
     * Draws current enemy.
     */
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.RED);
        g2.fillOval(x, y, size, size);
    }
    /**
     * Updates current enemy
     */
    @Override
    public void update() {
        switch (direction) {
            case "UP" -> y -= speed;
            case "DOWN" -> y += speed;
            case "LEFT" -> x -= speed;
            case "RIGHT" -> x += speed;
            default -> throw new IllegalArgumentException();
       }
    }
}
