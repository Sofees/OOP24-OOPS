package it.unibo.oops.model;

import java.awt.Graphics2D;
import java.awt.Color;


public class Player extends Entity {

    private String direction;

    public Player(int x, int y, int health, int speed) {
        super(x, y, health, speed);
        this.direction = "UP";
    }

    public String getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }   

    @Override
    public void update() {
       switch (direction) {
            case "UP":
                y -= speed;
                break;
            case "DOWN":
                y += speed;
                break;
            case "LEFT":
                x -= speed;
                break;
            case "RIGHT":
                x += speed;
                break;
       }     
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);    //colore rettangolo
        g.fillRect(x, y, 50, 50);
    }
}
