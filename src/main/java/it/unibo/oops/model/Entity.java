package it.unibo.oops.model;

import java.awt.Graphics2D;

public abstract class Entity {
    protected int x, y;         // Posizione
    protected int health;          // Salute
    protected int speed;        // Velocità
    protected boolean isAlive;     // Stato


    public Entity(int x, int y, int health, int speed) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.isAlive = true;
    }

    public abstract void draw(Graphics2D g);

    public abstract void update();

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isAlive() {
        return isAlive;
    }

    // Setter per la salute e altre variabili, se necessario
    public void setHealth(int health) {
        this.health = health;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}