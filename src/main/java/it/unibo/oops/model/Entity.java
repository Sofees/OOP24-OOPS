package it.unibo.oops.model;

import java.awt.Graphics2D;

    /**
     * 
     */
    public abstract class Entity {
    protected int x, y;         // Posizione
    protected int maxHealth;    // Salute Massima
    protected int health;          // Salute
    protected int size;        // Velocità
    protected int speed;        // Velocità
    protected boolean isAlive;     // Stato


    public Entity(int x, int y, int maxHealth, int health, int speed, int size) {
        this.x = x;
        this.y = y;
        this.maxHealth = maxHealth;
        this.health = health;
        this.speed = speed;
        this.size = size;
        this.isAlive = true;
    }
    /**
     * Draws an entity.
     */
    public abstract void draw(Graphics2D g);
    /**
     * Updates the entity.
     */
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
     * Gives the Entity's Size. 
     */
    public int getSize() {
        return size;
    }
    /**
     * Gives the Entity's alive status. 
     */
    public boolean isAlive() {
        return isAlive;
    }

    // Setter per la salute e altre variabili, se necessario
    /**
     * Sets the Entity's x position. 
     */
    public void setX(int x) {
        this.x = x;
    }
    /**
     * Sets the Entity's y position. 
     */
    public void setY(int y) {
        this.y = y;
    }
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
