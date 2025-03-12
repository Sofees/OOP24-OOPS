package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ItemManager {
    private final List<Item> items;

    public ItemManager() {
        items = new ArrayList<>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public void update() {
        items.forEach(Item::update);
    }

    public void draw(Graphics g) {
        for (Item item : items) {
            if (item instanceof ExperienceOrb || item instanceof Weapon) {
                ((ExperienceOrb) item).draw(g);
            }
        }
    }
}
