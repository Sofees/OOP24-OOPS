package it.unibo.oops.controller;

import it.unibo.oops.model.ItemManager;
import it.unibo.oops.model.Player;
import it.unibo.oops.view.GamePanel;
/**
* 
*/
public class GameThread implements Runnable {

    private static final double FPS = 60.0;

    private final GamePanel gp;
    private final Player player = new Player(200,200, 100, 5);
    private final ItemManager itemManager = new ItemManager(FPS, this.player);

    private Boolean running = true;
    /**
     * @param gp
     */
    public GameThread(final GamePanel gp) {
        this.gp = gp;
        gp.setPlayer(this.player);
        gp.setItemManager(this.itemManager);
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
            gp.repaint();
        }
    }
    /**
     *  Updates players, items, enemies.
     */
    public void update() {
        //chiama l'update di player, items, nemici etc.
        itemManager.update();
        player.update();
    }
    /**
     *  @return frames per second
     */
    public double getFps() {
        return FPS;
    }

}
