package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class WeaponManager {
    private final List<Weapon> weapons;
    private final double fps;
    private final Player player;
    /**
     * @param fps
     * @param player
     */
    public WeaponManager(final double fps, final Player player) {
        weapons = new ArrayList<>();
        this.fps = fps;
        this.player = player;
    }
    /**
     * Updates every weapon.
     */
    public void update() {
        if (!weapons.stream().anyMatch(item -> item instanceof Sword)) {
            weapons.add(new Sword(fps, player));
        }
        for (final Weapon weapon : weapons) {
            weapon.update();
        }
    }
    /**
    * Draws all the items in the list.
    * @param g
    */
    public void draw(final Graphics g) {
        for (final Weapon weapon : weapons) {
            weapon.draw(g);
        }
    }
}
