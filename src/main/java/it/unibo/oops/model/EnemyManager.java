package it.unibo.oops.model;

import java.util.List;
import java.awt.Graphics2D;
import java.util.ArrayList;
/*
 * 
 */
public class EnemyManager {

    private List<Enemy> enemyList = new ArrayList<>();
    private Player player;

    public EnemyManager(final Player player) {
        this.player = player;
    }
    public void update() {
        for (Enemy enemy : enemyList) {
            enemy.update();
        }
    }
    public void addEnemy(Enemy enemy) {
        enemyList.add(enemy);
    }
    public void spawnWave() {
    }
    public void draw(Graphics2D g2d) {
        for (Enemy enemy : enemyList) {
            enemy.draw(g2d);
        }
    }
}
