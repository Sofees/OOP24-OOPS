package it.unibo.oops.controller;

import java.util.logging.Logger;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
* 
*/
public class GameThread implements Runnable {

    double FPS = 60.0;


    private Boolean running = true;
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
     * Stops the gameThread.
     */
    public void stopThread() {
        this.running = false;
    }
    /**
     *  Thread.
     */
    @Override
    public void run() {
        long lastTime = System.nanoTime();
        double nanoFps = 1000000000 / FPS;
        double delta = 0;

        while (running) {
            long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / nanoFps;
            lastTime = currentTime;
            while (delta >= 1) {
                update();
                delta--;
            }
            draw();
        }
    }

    public void update() {
        //chiama l'update di player, items, nemici etc.
    }

    public void draw() {
        //chiama il draw di player, items, nemici etc.
    }

}
