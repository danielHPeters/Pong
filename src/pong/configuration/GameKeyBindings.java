package pong.configuration;

import pong.gameObjcects.Player;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class GameKeyBindings {

    /**
     *
     * @param panel
     * @param players
     */
    public GameKeyBindings(JPanel panel, ArrayList<Player> players) {
        initialize(panel, players);
    }

    /**
     *
     * @param panel
     * @param players
     */
    private void initialize(JPanel panel, ArrayList<Player> players) {
        // Get the input map of the GamePanel
        InputMap iMap = panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap aMap = panel.getActionMap();

        // put the action functions to the map
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W pressed");
        aMap.put("W pressed", setUp(players.get(0), true));
        // Boolean param true for key released
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W released");
        aMap.put("W released", setUp(players.get(0), false));

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        aMap.put("S pressed", setDown(players.get(0), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S released");
        aMap.put("S released", setDown(players.get(0), false));

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP pressed");
        aMap.put("UP pressed", setUp(players.get(1), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UP released");
        aMap.put("UP released", setUp(players.get(1), false));

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN pressed");
        aMap.put("DOWN pressed", setDown(players.get(1), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DOWN released");
        aMap.put("DOWN released", setDown(players.get(1), false));
    }

    /**
     *
     * @param player
     * @param needsToMoveUp
     * @return
     */
    public Action setUp(Player player, boolean needsToMoveUp) {
        Action upAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setUP(needsToMoveUp);
            }
        };
        return upAction;
    }

    /**
     *
     * @param player
     * @param needsToMoveDown
     * @return
     */
    public Action setDown(Player player, boolean needsToMoveDown) {
        Action downAction = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDOWN(needsToMoveDown);
            }
        };
        return downAction;
    }
}
