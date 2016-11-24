/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.configuration;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import pong.gameObjcects.Player;

/**
 *
 * @author d.peters
 */
public class Actions {
    /**
     * this method creates the methods for the up actions
     * @param player the player object
     * @param needsToMoveUp boolean which is true for key pressed and for for 
     * key released
     * @return the abstract action
     */
    public Action upAction(Player player, boolean needsToMoveUp) {
        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setUp(needsToMoveUp);
            }
        };
        return upAction;
    }

    /**
     * this method creates the methods for the down actions
     * @param player the player object
     * @param needsToMoveDown boolean which is true for key pressed and for for 
     * key released
     * @return the abstract action
     */
    public Action downAction(Player player, boolean needsToMoveDown) {
        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDown(needsToMoveDown);
            }
        };
        return downAction;
    }
}
