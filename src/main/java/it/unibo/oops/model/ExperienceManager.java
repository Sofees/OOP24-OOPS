package it.unibo.oops.model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

public class ExperienceManager {
    private final List<ExperienceOrb> orbs;
    private final double fps;
    private final Player player;
    private int playerXp;

    public ExperienceManager(final double fps, final Player player) {
        orbs = new ArrayList<>();
        this.fps = fps;
        this.player = player;
    }

    public void update() {
        for (ExperienceOrb orb : orbs) {
            if (Math.abs(player.getX() - (orb.getX())) <= 10 &&
                Math.abs(player.getY() - (orb.getY())) <= 10 ) {
                orbs.remove(orb);
                playerXp += orb.getXP();
            }
        }
    }

    public void draw(Graphics g) {
        for (ExperienceOrb experienceOrb : orbs) {
            experienceOrb.draw(g);
        }
    }

    public void spawnXP (int x, int y, int amount) {
        orbs.add(new ExperienceOrb(x, y, amount));
    }
}
