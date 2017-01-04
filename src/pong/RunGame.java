package pong;

import pong.uiElements.Painter;

/**
 * this class contains the painter loop, which controls painter speed, framerate
 * etc.
 *
 * @author d.peters
 */
public class RunGame implements Runnable {

    /**
     * 
     */
    private boolean playing;

    /**
     * 
     */
    private boolean paused;

    /**
     * 
     */
    private int gameSpeed; // The lower, the faster the painter

    /**
     * 
     */
    private final Painter painter;

    /**
     * 
     */
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
        this.playing = true;
    }
    
    /**
     * 
     */
    public void pauseToggle(){
        this.paused = !paused;
    }
    
    /**
     * 
     */
    public void end(){
        this.playing = false;
    }

    /**
     * setter for the painter speed / thread delay
     *
     * @param gameSpeed new painter speed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }
    
    /**
     * 
     */
    public void restartGame(){
        this.logic.reseGameObjects();
        this.logic.resetScores();
        this.painter.setGameOver(false);
        this.playing = true;
    }

    /**
     * 
     */
    @Override
    public void run() {

        while (playing && !painter.isGameOver()) {

            if (!paused) {
                // Move painter objects repaint
                this.logic.update();
                this.painter.repaint();
            }

            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {
                this.playing = false;
            }

        }
    }
}
