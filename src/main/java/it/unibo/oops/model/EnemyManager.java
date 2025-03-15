package it.unibo.oops.model;

import java.util.List;
import java.awt.Graphics2D;
import java.util.ArrayList;
/**
 * 
 */
public class EnemyManager {
    private static int WAVE_SIZE = 8;
    private List<Enemy> enemyList = new ArrayList<>();
    private Player player;

    public EnemyManager(final Player player) {
        this.player = player;
    }
    /**
    * Updates every enemy.
    */
    public void update() {
        for (int i = 0; i < WAVE_SIZE; i++) {
            if (!enemyList.isEmpty()) {
                if(!enemyList.get(i).isPositioned()) {
                    double angle = 2 * Math.PI * i / WAVE_SIZE; // Divide circle into equal parts
                int x = (int) ((player.getX() + player.getSize() / 2) + 200 * Math.cos(angle) - enemyList.get(i).size / 2);
                int y = (int) ((player.getY() + player.getSize() / 2) + 200 * Math.sin(angle) - enemyList.get(i).size / 2);
                enemyList.get(i).setX(x);
                enemyList.get(i).setY(y);
                enemyList.get(i).setPosition(true);
                //enemyList.get(i).setSpeed(0);
                }
                enemyList.get(i).update();
            }
        }
    }
    /**
    * Adds an enemy to the list.
    */
    public void addEnemy(Enemy enemy) {
            enemyList.add(enemy);
    }
    /**
    * Draws every enemy.
    */
    public void drawWave(Graphics2D g2d) {
        for (int i = 0; i < WAVE_SIZE; i++) {
            enemyList.get(i).draw(g2d);
        }
    }
}
