package it.unibo.oops.model;
import java.awt.Color;
import java.awt.Graphics;

public class Sword {

    private static final int WIDTH = 10;
    private static final int HEIGHT = 30;
    private static final double DURATION = 0.5;
    private static final double COOLDOWN = 1.5;

    private double timer;
    private double cooldown;
    private boolean active;
    private final Player player;

    public Sword(double fps, Player player) {
        this.active = false;
        this.timer = fps*DURATION;
        this.cooldown = fps*COOLDOWN;
        this.player = player;
    }
    
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

    public void draw(Graphics g) {
        if (active) {
            g.setColor(Color.BLUE);
            int drawX = player.getX(), drawY = player.getY();
            switch (player.getDirection()) {
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
