package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class ItemManager {
    private final List<Item> items;
    
    public ItemManager() {
        items = new ArrayList<>();
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
        items.forEach(Item::update);
    }
    /**
    * Draws all the items in the list.
    */
    public void draw(Graphics g) {
        for (Item item : items) {
            if (item instanceof ExperienceOrb || item instanceof Weapon) {
                ((ExperienceOrb) item).draw(g);
            }
        }
    }
}
