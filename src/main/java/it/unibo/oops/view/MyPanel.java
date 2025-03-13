package it.unibo.oops.view;

import javax.swing.JPanel;

import it.unibo.oops.model.ItemManager;
import it.unibo.oops.model.Player;
/**
 * 
 */
public abstract class MyPanel extends JPanel {
    private static final double serialVersionUID = 0.01;

    private Player player;
    private ItemManager itemManager;
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
     * Sets the current itemManager
     */
    public void setItemManager(final ItemManager itemManager) {
        this.itemManager = itemManager;
    }
    /**
    * Gets the current player.
    */
    public Player getPlayer() {
        return this.player;
    }
    /**
     * Gets the current itemManager
     */
    public ItemManager getItemManager() {
        return this.itemManager;
    }
}
