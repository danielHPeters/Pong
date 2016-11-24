package pong;

import pong.uiElements.Painter;

/**
 * this class contains the painter loop, which controls painter speed, framerate
 * etc.
 *
 * @author d.peters
 */
public class RunGame implements Runnable {

    private boolean playing;
    private int gameSpeed; // The lower, the faster the painter
    private final Painter painter;
    private final GameLogic logic;

    /**
     * default constructor which fetches the Painter objecct and sets the
     * painter to playing mode
     *
     * @param game
     * @param logic
     */
    public RunGame(Painter game, GameLogic logic) {
        this.painter = game;
        this.logic = logic;
        this.gameSpeed = 18;
    }

    /**
     * setter for the painter speed / thread delay
     *
     * @param gameSpeed new painter speed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    @Override
    public void run() {
        this.playing = true;
        while (playing && !painter.isGameOver()) {
            // Move painter objects repaint
            this.logic.update();
            this.painter.repaint();
            // Delay loop to avoid instant painter over
            try {
                Thread.sleep(this.gameSpeed);
            } catch (InterruptedException ex) {

            }
        }
    }
}
