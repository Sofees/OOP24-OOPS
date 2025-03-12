package it.unibo.oops.controller;
import it.unibo.oops.model.Player;  
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
* 
*/
public class GameThread implements Runnable {

    private final double FPS = 60.0;
    private Player player; 

    private Boolean running = true;
    /**
     * 
     */
    public GameThread() {
        this.player = new Player(100, 100, 100, 5.0);
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
        player.update();
    }

    public void draw(Graphics g) {
        //chiama il draw di player, items, nemici etc.
        Graphics2D g2d = (Graphics2D) g;
        player.draw(g2d);
    }

    public double getFps() {
        return this.FPS;
    }

}
