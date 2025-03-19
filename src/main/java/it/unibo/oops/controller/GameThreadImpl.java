package it.unibo.oops.controller;

import it.unibo.oops.controller.gamestate.GameState;
import it.unibo.oops.model.EnemyFactory;
import it.unibo.oops.model.EnemyFactoryImpl;
import it.unibo.oops.model.EnemyManager;
import it.unibo.oops.model.ExperienceManager;
import it.unibo.oops.model.Player;
import it.unibo.oops.model.Timer;
import it.unibo.oops.model.TimerImpl;
import it.unibo.oops.model.WeaponManager;
import it.unibo.oops.view.DrawViewImpl;
/**
* 
*/
public class GameThreadImpl implements Runnable, GameThread {
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

    private final Timer timer = new TimerImpl(1);
    private final Player player = new Player(PLAYER_X, PLAYER_Y, PLAYER_MAX_HEALTH, PLAYER_HEALTH, PLAYER_SPEED, PLAYER_SIZE);
    private final EnemyManager enemyManager = new EnemyManager(player);
    private final EnemyFactory enemyFactory = new EnemyFactoryImpl();
    private final WeaponManager weaponManager = new WeaponManager(player);
    private final ExperienceManager experienceManager = new ExperienceManager(/*FPS, */player);
    private final DrawViewImpl window = 
    new DrawViewImpl(GameState.TITLESTATE, this.player, this.enemyManager, this.weaponManager, this.experienceManager);

    private Boolean running = true;
    /**
     *
     */
    public GameThreadImpl() {
        this.startThread();
        InputHandler inputHandler = new InputHandler(player);
        window.addKeyListener(inputHandler);
        window.setFocusable(true);
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
    @Override
    public void stopThread() {
        this.running = false;
    }
    /**
     *  Thread.
     */
    @Override
    public void run() {
        while (running) {
            timer.update(this::update);
            if (this.window.getCurrentGameState() == GameState.PLAYSTATE) {
                this.enemyManager.
                addEnemy(this.enemyFactory.
                createSlime(ENEMY_X, ENEMY_Y, ENEMY_MAXHEALTH, ENEMY_HEALTH, ENEMY_SPEED, ENEMY_SIZE * 2, this.player));
                this.window.repaint();
            }
        }
    }
    /**
     *  Updates players, items, enemies.
     */
    @Override
    public void update() {
        if (this.window.getCurrentGameState() == GameState.PLAYSTATE) {
            weaponManager.update();
            experienceManager.update();
            player.update();
            enemyManager.update();
        }
    }
}
