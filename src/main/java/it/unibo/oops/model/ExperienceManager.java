package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 */
public class ExperienceManager {
    private final List<ExperienceOrb> orbs;
    @SuppressWarnings("unused") // TEMPORARY
    private final double fps;
    private final Player player;
    @SuppressWarnings("unused") // TEMPORARY
    private int playerXp;
    /**
     * @param fps
     * @param player
     */
    public ExperienceManager(final double fps, final Player player) {
        orbs = new ArrayList<>();
        this.fps = fps;
        this.player = player;
    }
    /**
     * Updates every experienceOrb.
     */
    public void update() {
        for (final ExperienceOrb orb : orbs) {
            if (Math.abs(player.getX() - orb.getX()) <= 10 
                && Math.abs(player.getY() - orb.getY()) <= 10) {
                orbs.remove(orb);
                playerXp += orb.getXP();
            }
        }
    }
    /**
     * Draws every experienceOrn.
     * @param g
     */
    public void draw(final Graphics g) {
        for (final ExperienceOrb experienceOrb : orbs) {
            experienceOrb.draw(g);
        }
    }
    /**
     * Spawns an experienceOrb.
     * @param x
     * @param y
     * @param amount
     */
    public void spawnXP(final int x, final int y, final int amount) {
        orbs.add(new ExperienceOrb(x, y, amount));
    }
}
