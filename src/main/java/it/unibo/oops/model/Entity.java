package it.unibo.oops.model;

public abstract class Entity {
    protected double x, y;         // Posizione
    protected int health;          // Salute
    protected double speed;        // Velocità
    protected boolean isAlive;     // Stato


    public Entity(double x, double y, int health, double speed) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
        this.isAlive = true;
    }
    
    @Override
    public abstract void draw(Graphics g);
}