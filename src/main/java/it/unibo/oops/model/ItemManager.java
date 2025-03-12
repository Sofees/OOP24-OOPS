package it.unibo.oops.model;

import java.util.LinkedList;
import java.util.List;

public class ItemManager {
    List<Item> items = new LinkedList<>();

    public void update() {
        for (Item item : items) {
            item.update();
        }
    }

    public void draw() {
        for (Item item : items) {

        }
    }
}
