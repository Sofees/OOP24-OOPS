package it.unibo.oops.model;
import java.awt.Color;
import java.awt.Graphics;

public class Sword {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 30;
    private static final int DURATION = 30;
    private static final int COOLDOWN = 90;

    private int timer;
    private int cooldown;
    private boolean active;

    public Sword() {
        this.active = false;
        this.timer = 0;
        this.cooldown = 0;
    }
    
    public void update() {
        if (active) {
            timer--;
            if (timer <= 0) {
                active = false;
                this.cooldown = COOLDOWN;
            }
        } else {
            if (cooldown <= 0) {
                this.active = true;
            } else {
                cooldown--;
            }
        }
    }

    public void draw(Graphics g) {
        if (active) {
            g.setColor(Color.BLUE);
            int drawX = player.x, drawY = player.y;
            switch (player.direction) {
                case "UP":
                    drawX -= WIDTH / 2;
                    drawY -= HEIGHT;
                    break;
                case "RIGHT": 
                    drawX += WIDTH;
                    drawY -= HEIGHT / 2;
                    break;
                case "DOWN":
                    drawX -= WIDTH / 2;
                    drawY += HEIGHT;
                    break;
                case "LEFT":
                    drawX -= WIDTH;
                    drawY -= HEIGHT / 2;
                    break;
                }
            g.fillRect(drawX, drawY, WIDTH, HEIGHT);
        }
    }
}
