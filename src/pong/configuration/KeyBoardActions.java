package pong.configuration;

import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import pong.GameState;
import pong.models.Player;

/**
 *
 * @author d.peters
 */
public class KeyBoardActions {

    /**
     * this method creates the methods for the up actions
     *
     * @param player the player object
     * @param toggleUp boolean which is true for key pressed and for for key
     * released
     * @return the abstract action
     */
    public Action upAction(Player player, boolean toggleUp) {
        Action upAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.setUp(toggleUp);
            }

        };
        return upAction;
    }

    /**
     * this method creates the methods for the down actions
     *
     * @param player the player object
     * @param ToggleDown boolean which is true for key pressed and for for key
     * released
     * @return the abstract action
     */
    public Action downAction(Player player, boolean ToggleDown) {

        Action downAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDown(ToggleDown);
            }

        };

        return downAction;
    }

    /**
     *
     * @param window
     * @param game
     * @param executor
     * @return
     */
    public Action escAction(JFrame window, GameState game,
            ScheduledThreadPoolExecutor executor) {

        Action esc = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.setPlaying(false);
                executor.shutdown();
                window.dispose();
            }

        };

        return esc;
    }

    /**
     *
     * @param game
     * @return
     */
    public Action restartAction(GameState game) {

        Action restart = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }

        };

        return restart;
    }

}
