package it.unibo.oops.controller;

import java.util.logging.Logger;
import java.util.logging.Level;

/**
* 
*/
public class GameThread implements Runnable {

    private Boolean stop = true;
    /**
     * 
     */
    public GameThread() {
        this.startThread();
    }
    /**
     * Starts the gameThread.
     */
    private void startThread() {
        final Thread thread = new Thread(this);
        thread.start();
    }
    /**
     *  Thread.
     */
    @Override
    public void run() {
        while (stop) {
            this.stop = false;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Logger.getLogger(GameThread.class.getName()).log(Level.SEVERE, "Sleep Thread Error", e);
            }
        }
    }

}
