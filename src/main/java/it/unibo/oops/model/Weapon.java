package it.unibo.oops.model;
import java.awt.Graphics;

public abstract class Weapon extends Item {
    
    public abstract void update();
    public abstract void draw(Graphics g); 
}
