package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.Color;


public class Player extends Entity {


    public Player(double x, double y, int health, double speed) {
        super(x, y, health, speed);
    }


    public void draw(Graphics2D g) {
        g.setColor(Color.green);
        g.fillRect((int) x, (int) y, 50, 50);
    }

    public void update() {

    }
}