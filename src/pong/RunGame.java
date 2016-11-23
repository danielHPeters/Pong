package pong;

import pong.uiElements.GameArea;

/**
 * this class contains the game loop, which controls game speed, framerate etc.
 * @author d.peters
 */
public class RunGame implements Runnable{

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
        this.playing = false;
    }

    /**
     * setter for the game speed / thread delay
     * @param gameSpeed new game speed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    @Override
    public void run() {
        this.playing = true;
        while (playing && !game.isGameOver()) {
            // Move game objects repaint
            this.game.update();
            this.game.repaint();
            // Delay loop to avoid instant game over
            try {
                Thread.sleep(this.gameSpeed);
            } catch (InterruptedException ex) {

            }
        }
    }
}
