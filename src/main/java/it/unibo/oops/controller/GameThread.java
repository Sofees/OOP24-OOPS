package it.unibo.oops.controller;

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
            //this.stop = false;
        }
    }

}
