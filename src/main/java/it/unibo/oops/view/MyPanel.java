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
    /**
     * Font size value.
     */
    protected static final int FONT_SIZE = 24;
    /**
     * Horizontal border value.
     */
    protected static final int HORIZONTAL_BORDER = 50;
    /**
     * Vertical border value.
     */
    protected static final int VERTICAL_BORDER = 20;
    /**
     * Rows in gridLayout.
     */
    protected static final int ROWS = 5;
    /**
     * Columns in gridLayout.
     */
    protected static final int COLUMNS = 1;
    /**
     * Size of the horizontal and vertical gap in gridLayout.
     */
    protected static final int GAP = 10;

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
     * @param player
     */
    public void setPlayer(final Player player) {
        this.player = player;
    }
    /**
    * Sets an enemyManager.
    * @param enemyManager
    */
    public void setEnemyManager(final EnemyManager enemyManager) {
        this.enemyManager = enemyManager;
    }
    /**
    * Sets an enemy.
    * @param enemy
    */
    public void setEnemy(final Enemy enemy) {
        this.enemy = enemy;
    }
    /**
     * Sets the current weaponManager.
     * @param weaponManager
     */
    public void setWeaponManager(final WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
    }
    /**
     * Sets the current experienceManager.
     * @param experienceManager
     */
    public void setExperienceManager(final ExperienceManager experienceManager) {
        this.experienceManager = experienceManager;
    }
    /**
    * Gets the current player.
    * @return the current player.
    */
    public Player getPlayer() {
        return this.player;
    }
    /**
    * Gets the current enemyManager.
    * @return the current enemyManager.
    */
    public EnemyManager getEnemyManager() {
        return this.enemyManager;
    }
    /**
    * Gets the current enemy.
    * @return the current enemy.
    */
    public Enemy getEnemy() {
        return this.enemy;
    }
    /**
     * Gets the current weaponManager.
     * @return the current weaponManager.
     */
    public WeaponManager getWeaponManager() {
        return this.weaponManager;
    }
    /**
     * Gets the current experienceManager.
     * @return the current experienceManager.
     */
    public ExperienceManager getExperienceManager() {
        return this.experienceManager;
    }
}
