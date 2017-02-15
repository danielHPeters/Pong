package pong;

import javax.swing.JPanel;

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
    private final JPanel painter;

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
    public RunGame(JPanel painter, GameLogic logic) {
        this.painter = painter;
        this.logic = logic;
    }

    /**
     * 
     */
    @Override
    public void run() {

        while (this.logic.getGame().isPlaying()) {

            if (!logic.getGame().isPaused()) {
                // Move painter objects repaint
                this.logic.update();
                this.painter.repaint();
            }

            try {
                Thread.sleep(this.logic.getGame().getConfig().getGameSpeed());
            } catch (InterruptedException ex) {
                this.logic.getGame().setPlaying(false);
            }

        }
    }
}
