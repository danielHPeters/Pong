package pong.configuration;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
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
     * @param toggleUp boolean which is true for key pressed and for for
     * key released
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
     * @param ToggleDown boolean which is true for key pressed and for for
     * key released
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
    
    public Action escAction(GameWindow window, Thread gameThread){

        Action esc = new AbstractAction(){
            @Override
            public void actionPerformed(ActionEvent e) {
                window.dispose();
            }
        };
        
        return esc;
    }
    
}
