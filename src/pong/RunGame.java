package pong;

import java.util.logging.Level;
import java.util.logging.Logger;
import pong.uiElements.Painter;

/**
 * this class contains the painter loop, which controls painter speed, framerate
 * etc.
 *
 * @author d.peters
 */
public class RunGame implements Runnable {

    private boolean playing;

    private boolean paused;

    private int gameSpeed; // The lower, the faster the painter

    private final Painter painter;

    private final GameLogic logic;

    /**
     * default constructor which fetches the Painter objecct and sets the
     * painter to playing mode
     *
     * @param painter
     * @param logic
     */
    public RunGame(Painter painter, GameLogic logic) {
        this.painter = painter;
        this.logic = logic;
        this.gameSpeed = 18;
        this.paused = false;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
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

            if (!paused) {
                // Move painter objects repaint
                this.logic.update();
                this.painter.repaint();
            }

            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {
                Logger.getLogger(RunGame.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
}
