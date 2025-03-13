package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class WeaponManager {
    private final List<Weapon> weapons;
    private final double fps;
    private final Player player;
    
    public WeaponManager(double fps, Player player) {
        weapons = new ArrayList<>();
        this.fps = fps;
        this.player = player;
    }

    public void update() {
        if (!weapons.stream().anyMatch(item -> item instanceof Sword)) {
            weapons.add(new Sword(fps, player));
        }
        for (Weapon weapon : weapons) {
            weapon.update();
        }
    }
    /**
    * Draws all the items in the list.
    */
    public void draw(Graphics g) {
        for (Weapon weapon : weapons) {
            weapon.draw(g);
        }
    }
}
