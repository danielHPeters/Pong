package pong;

import pong.uiElements.GameArea;

/**
 * this class contains the game loop, which controls game speed, framerate etc.
 * @author d.peters
 */
public class RunGame {

    private boolean playing;
    private int gameSpeed = 18; // The lower, the faster the game
    private final GameArea game;

    /**
     * default constructor which fetches the GameArea objecct and sets the game
     * to playing mode
     * @param game 
     */
    public RunGame(GameArea game) {
        this.game = game;
        this.playing = true;
    }

    /**
     * getter for playing boolean
     * @return boolean telling if the game is still playing
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * setter for playing boolean
     * @param playing new playing status
     */
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    /**
     * getter for the game speed / thread delay
     * @return the current game speed
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     * setter for the game speed / thread delay
     * @param gameSpeed new game speed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    /**
     * this method start the thread which runs the game loop
     */
    public void runLoop() {
        Thread loop = new Thread() {
            @Override
            public void run() {
                gameLoop();
            }
        };
        loop.start();
    }

    /**
     * the actual game loop which updates the game object positions and
     * invokes the repaint method of the gameArea.
     * the delay determines the speed of the game
     */
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
