package pong.configuration;

import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import pong.RunGame;
import pong.gameObjcects.Player;
import pong.uiElements.GameWindow;

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
     * @param loop
     * @param executor
     * @return
     */
    public Action escAction(GameWindow window, RunGame loop,
            ScheduledThreadPoolExecutor executor) {

        Action esc = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Exiting game. Thanks for Playing!");
                loop.end();
                executor.shutdown();
                window.dispose();
            }

        };

        return esc;
    }

    /**
     *
     * @param loop
     * @return
     */
    public Action restartAction(RunGame loop) {

        Action restart = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                loop.restartGame();
            }

        };

        return restart;
    }

}
