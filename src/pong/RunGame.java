/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import pong.uiElements.GameArea;

/**
 *
 * @author d.peters
 */
public class RunGame {

    private boolean playing;
    private int gameSpeed = 18; // The lower, the faster the game
    private final GameArea game;

    public RunGame(GameArea game) {
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

    public void runLoop() {
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
            // Move game objects repaint
            game.update();
            game.repaint();
            // Delay loop to avoid instant game over
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {

            }
        }
    }
}
