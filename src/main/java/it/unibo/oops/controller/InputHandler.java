package it.unibo.oops.controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import it.unibo.oops.model.Player;
import it.unibo.oops.model.Direction;

public class InputHandler extends KeyAdapter {
    private Player player;

    public InputHandler(Player player) {
        this.player = player;
    
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
    
        if (key == KeyEvent.VK_W) {
            player.setDirection(Direction.UP);
        } else if (key == KeyEvent.VK_S) {
            player.setDirection(Direction.DOWN);
        } else if (key == KeyEvent.VK_A) {
            player.setDirection(Direction.LEFT);
        } else if (key == KeyEvent.VK_D) {
            player.setDirection(Direction.RIGHT);
        }
    }
}
