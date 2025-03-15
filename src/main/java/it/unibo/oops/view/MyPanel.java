package it.unibo.oops.view;

import javax.swing.JPanel;

import it.unibo.oops.model.Enemy;
import it.unibo.oops.model.EnemyManager;
import it.unibo.oops.model.ExperienceManager;
import it.unibo.oops.model.Player;
import it.unibo.oops.model.WeaponManager;
/**
 * 
 */
public abstract class MyPanel extends JPanel {
    private static final double serialVersionUID = 0.01;

    private Player player;
    private EnemyManager enemyManager;
    private Enemy enemy;
    private WeaponManager weaponManager;
    private ExperienceManager experienceManager;
    /**
    *  @return the SerialVersionUID
    */
    public static double getSerialVersionUID() {
        return serialVersionUID;
    }
    /**
    * Sets the current player.
    */
    public void setPlayer(final Player player) {
        this.player = player;
    }
    /**
    * Sets an enemyManager.
    */
    public void setEnemyManager(final EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }
    /**
    * Sets an enemy.
    */
    public void setEnemy(final Enemy enemy) {
        this.enemy = enemy;
    }
    /**
     * Sets the current weaponManager
     */
    public void setWeaponManager(final WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
    }
    /**
     * Sets the current experienceManager
     */
    public void setExperienceManager(final ExperienceManager experienceManager) {
        this.experienceManager = experienceManager;
    }
    /**
    * Gets the current player.
    */
    public Player getPlayer() {
        return this.player;
    }
    /**
    * Gets the current enemyManager.
    */
    public EnemyManager getEnemyManager() {
        return this.enemyManager;
    }
    /**
    * Gets the current enemy.
    */
    public Enemy getEnemy() {
        return this.enemy;
    }
    /**
     * Gets the current weaponManager
     */
    public WeaponManager getWeaponManager() {
        return this.weaponManager;
    }
    /**
     * Gets the current experienceManager
     */
    public ExperienceManager getExperienceManager() {
        return this.experienceManager;
    }
}
