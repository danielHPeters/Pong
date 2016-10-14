/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import pong.uiElements.GamePanel;

/**
 *
 * @author d.peters
 */
public class RunGame {

    private boolean playing;
    private int gameSpeed = 30; // The lower, the faster the game
    private GamePanel game;

    public RunGame(GamePanel game) {
        this.game = game;
        this.playing = true;
    }

    /**
     *
     * @return
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     *
     * @param playing
     */
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    /**
     *
     * @return
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     *
     * @param gameSpeed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public void runGameLoop() {
        Thread loop = new Thread() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        loop.start();
    }

    public void gameLoop() {
        while (playing && !game.isGameOver()) {
            /**
             * Delay the game loop (otherwise the game will instantly end) the
             * duration of the delay also determines the speed of the game
             *
             */
            game.update();
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {

            }
            game.repaint();
        }
    }
}
