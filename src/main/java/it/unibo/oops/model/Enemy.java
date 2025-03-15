package it.unibo.oops.model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;
/*
 * 
 */
public class Enemy extends Entity {

    Player player;
    private String direction;
    public Enemy(int x, int y, int maxHealth, int health, int speed, int size) {
        super(x, y, maxHealth, health, speed, size);
        this.direction = "UP";
    }
    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(Color.MAGENTA);
        g2.fillOval(x, y, size, size);
    }

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
