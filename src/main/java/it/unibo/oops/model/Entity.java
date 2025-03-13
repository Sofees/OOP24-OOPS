package it.unibo.oops.model;

import java.awt.Graphics2D;

    /**
     * 
     */
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
    /**
     * Gives the entity's X coordinate. 
     */
    public int getX() {
        return x;
    }
    /**
     * Gives the Entity's Y coordinate. 
     */
    public int getY() {
        return y;
    }
    /**
     * Gives the Entity's health value. 
     */
    public int getHealth() {
        return health;
    }
    /**
     * Gives the Entity's speed value. 
     */
    public int getSpeed() {
        return speed;
    }
    /**
     * Gives the Entity's alive status. 
     */
    public boolean isAlive() {
        return isAlive;
    }

    // Setter per la salute e altre variabili, se necessario
    /**
     * Sets the Entity's health value. 
     */
    public void setHealth(int health) {
        this.health = health;
    }
    /**
     * Sets the Entity's speed value. 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    /**
     * Sets the Entity's alive status. 
     */
    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
