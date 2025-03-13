package it.unibo.oops.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import it.unibo.oops.model.ExperienceManager;
import it.unibo.oops.model.Player;
import it.unibo.oops.model.WeaponManager;
/**
 * 
 */
public class GamePanel extends MyPanel { 
    @SuppressWarnings("unused") // TEMPORARY

    private static final double serialVersionUID = getSerialVersionUID();
    /**
     * @param screenWidth
     * @param screenHeight
     */

    private Player player;
    private WeaponManager weaponManager;
    private ExperienceManager experienceManager;
    /**
     *
     */
    public GamePanel(final int screenWidth, final int screenHeight) {
        super.setPreferredSize(new Dimension(screenWidth, screenHeight));
        super.setBackground(Color.RED);
    }
    /**
     * Sets the current player.
     */
    public void setPlayer(final Player player) {
        this.player = player;
    }
    /**
     * Sets the current itemManager
     */
    public void setWeaponManager(final WeaponManager weaponManager) {
        this.weaponManager = weaponManager;
    }

    public void setExperienceManager(final ExperienceManager experienceManager) {
        this.experienceManager = experienceManager;
    }

    protected void paintComponent(final Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
        weaponManager.draw(g2d);
    }

}
