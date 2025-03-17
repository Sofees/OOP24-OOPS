package it.unibo.oops.controller;

import it.unibo.oops.controller.gamestate.GameState;
import it.unibo.oops.model.EnemyFactory;
import it.unibo.oops.model.EnemyFactoryImpl;
import it.unibo.oops.model.EnemyManager;
import it.unibo.oops.model.ExperienceManager;
import it.unibo.oops.model.Player;
import it.unibo.oops.model.WeaponManager;
import it.unibo.oops.view.DrawViewImpl;
/**
* 
*/
public class GameThread implements Runnable {

    private static final double FPS = 60.0;
    private static final double NANO_FPS = 1_000_000_000 / FPS; 
    private static final int MAX_DELTA = 1;
    private static final int PLAYER_X = 200;
    private static final int PLAYER_Y = 200;
    private static final int PLAYER_MAX_HEALTH = 100;
    private static final int PLAYER_HEALTH = 100;
    private static final int PLAYER_SPEED = 5;
    private static final int PLAYER_SIZE = 50;
    private static final int ENEMY_X = 300;
    private static final int ENEMY_Y = 200;
    private static final int ENEMY_MAXHEALTH = 100;
    private static final int ENEMY_HEALTH = 100;
    private static final int ENEMY_SPEED = 2;
    private static final int ENEMY_SIZE = 50;

    private final DrawViewImpl window;
    private final Player player = new Player(PLAYER_X, PLAYER_Y, PLAYER_MAX_HEALTH, PLAYER_HEALTH, PLAYER_SPEED, PLAYER_SIZE);
    private final EnemyManager enemyManager = new EnemyManager(player);
    private final EnemyFactory enemyFactory = new EnemyFactoryImpl();
    private final WeaponManager weaponManager = new WeaponManager(FPS, player);
    private final ExperienceManager experienceManager = new ExperienceManager(FPS, player);

    private Boolean running = true;
    /**
     * @param window
     */
    public GameThread(final DrawViewImpl window) {
        this.window = window;
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
        double delta = 0;

        while (running) {
            final long currentTime = System.nanoTime();
            delta += (currentTime - lastTime) / NANO_FPS;
            lastTime = currentTime;
            while (delta >= MAX_DELTA) {
                update();
                delta--;
            }
            //NOTA: Soluzione Temporanea per stampare a schermo correttamente, da cambiare
            if (this.window.getCurrentGameState() == GameState.PLAYSTATE) {
                this.enemyManager.
                addEnemy(this.enemyFactory.
                createSlime(ENEMY_X, ENEMY_Y, ENEMY_MAXHEALTH, ENEMY_HEALTH, ENEMY_SPEED, ENEMY_SIZE * 2));
                if (this.window.getCurrentPanel().getPlayer() == null) {
                    this.window.getCurrentPanel().setPlayer(this.player);
                    this.window.getCurrentPanel().setEnemyManager(enemyManager);
                    this.window.getCurrentPanel().setWeaponManager(this.weaponManager);
                    this.window.getCurrentPanel().setExperienceManager(this.experienceManager);
                }
                this.window.getCurrentPanel().repaint();
            }
        }
    }
    /**
     *  Updates players, items, enemies.
     */
    public void update() {
        //chiama l'update di player, items, nemici etc.
        if (this.window.getCurrentGameState() == GameState.PLAYSTATE) {
            weaponManager.update();
            experienceManager.update();
            player.update();
            enemyManager.update();
        }
    }
    /**
     *  @return frames per second
     */
    public double getFps() {
        return FPS;
    }

}
