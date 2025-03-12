package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.Color;


public class Player extends Entity {

    private boolean UP, DOWN, LEFT, RIGHT;
    private int direction;

    public Player(double x, double y, int health, double speed) {
        super(x, y, health, speed);
    }

    public void setUP(boolean UP) {
        this.UP = UP;
        if (UP) direction = 0;
    }

    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
        if (DOWN) direction = 1;
    }

    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
        if (LEFT) direction = 2;
    }

    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
        if (RIGHT) direction = 3;
    }

    @Override
    public void update() {
        if (UP) y -= speed;
        if (DOWN) y += speed;
        if (LEFT) x -= speed;
        if (RIGHT) x += speed;
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);    //colore rettangolo
        g.fillRect((int) x, (int) y, 50, 50);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public int getDirection() {
        return direction;
    }
}