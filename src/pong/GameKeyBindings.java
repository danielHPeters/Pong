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
    public GameKeyBindings(JPanel panel, Flipper playerOne, Flipper playerTwo) {
        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 playerTwo.UP = true;
            }
        };

        Action upReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.UP = false;
            }
        };

        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.DOWN = true;
            }
        };

        Action downReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerTwo.DOWN = false;
            }
        };

        Action wAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.UP = true;
            }

        };

        Action wReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.UP = false;
            }
        };

        Action sAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playerOne.getY() <= panel.getHeight() - 30) {
                    playerOne.DOWN = true;
                }
            }
        };

        Action sReleasedAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerOne.DOWN = false;
            }
        };
        
        InputMap inputMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = panel.getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W pressed");
        actionMap.put("W pressed", wAction);
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
