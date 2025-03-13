package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class ItemManager {
    private final List<Item> items;
    private final double fps;
    private final Player player;
    
    public ItemManager(double fps, Player player) {
        items = new ArrayList<>();
        this.fps = fps;
        this.player = player;
    }
    /**
    * Adds an item to the list.  
    */
    public void addItem(Item item) {
        items.add(item);
    }
    /**
    * Removes an item from the list.  
    */
    public void removeItem(Item item) {
        items.remove(item);
    }
    /**
    * Updates all the items in the list.
    */
    public void update() {
        if (!items.stream().anyMatch(item -> item instanceof Sword)) {
            items.add(new Sword(fps, player));
        }
        items.forEach(Item::update);
    }
    /**
    * Draws all the items in the list.
    */
    public void draw(Graphics g) {
        for (Item item : items) {
            if (item instanceof ExperienceOrb) {
                ((ExperienceOrb)item).draw(g);
            }
            if (item instanceof Weapon) {
                ((Weapon)item).draw(g);
            }
        }
    }
}
