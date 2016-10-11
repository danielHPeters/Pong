/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.*;

/**
 *
 * @author d.peters
 */
public class GameKeyBindings {
    /**
     * 
     * @param panel
     * @param playerOne
     * @param playerTwo 
     */
    public GameKeyBindings(JPanel panel, Paddle playerOne, Paddle playerTwo) {

        /* Key pressed and key released actions */
        
        
        // UP arrow functions
        
        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 playerTwo.setUP(true);
            }
        };

        Action upReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.setUP(false);
            }
        };

        // DOWN arrow functions
        
        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.setDOWN(true);
            }
        };

        Action downReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.setDOWN(false);
            }
        };
        
        // W key functions

        Action wAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.setUP(true);
            }

        };
        
        Action wReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.setUP(false);
            }
        };
        
        // S key functions

        Action sAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    playerOne.setDOWN(true);
            }
        };

        Action sReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.setDOWN(false);
            }
        };
        
        // Get the input map of the GamePanel and put the action functions to the map
        InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();
        
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W pressed");
        actionMap.put("W pressed", wAction);
        // Boolean param true for key released
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W released");
        actionMap.put("W released", wReleasedAction);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        actionMap.put("S pressed", sAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S released");
        actionMap.put("S released", sReleasedAction);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP pressed");
        actionMap.put("UP pressed", upAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UP released");
        actionMap.put("UP released", upReleasedAction);

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN pressed");
        actionMap.put("DOWN pressed", downAction);
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DOWN released");
        actionMap.put("DOWN released", downReleasedAction);
    }
}
