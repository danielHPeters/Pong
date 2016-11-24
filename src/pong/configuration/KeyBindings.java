package pong.configuration;

import pong.gameObjcects.Player;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class KeyBindings {

    private final Actions actions;
    private final JPanel panel;
    ArrayList<Player> players;

    /**
     * default constructor which initializes the keyboard configs
     *
     * @param panel the game area object
     * @param players the ArrayList with all player objects
     * @param actions
     */
    public KeyBindings(JPanel panel, ArrayList<Player> players, Actions actions) {
        this.actions = actions;
        this.panel = panel;
        this.players = players;
        initialize();
    }

    /**
     * initialization method which binds keys to action methods
     *
     * @param panel the game area object
     * @param players ArrayList with all player objects
     */
    private void initialize() {
        // Get the input map of the GamePanel
        InputMap iMap = this.panel.getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap aMap = this.panel.getActionMap();

        /* W key */
        // put the action functions to the map
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false), "W pressed");
        aMap.put("W pressed", this.actions.upAction(this.players.get(0), true));
        // Boolean param true for key released
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true), "W released");
        aMap.put("W released", this.actions.upAction(this.players.get(0), false));

        /* S key */
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false), "S pressed");
        aMap.put("S pressed", this.actions.downAction(this.players.get(0), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true), "S released");
        aMap.put("S released", this.actions.downAction(this.players.get(0), false));

        /* UP Arrow key */
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "UP pressed");
        aMap.put("UP pressed", this.actions.upAction(this.players.get(1), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true), "UP released");
        aMap.put("UP released", this.actions.upAction(this.players.get(1), false));

        /* DOWN Arrow key */
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false), "DOWN pressed");
        aMap.put("DOWN pressed", this.actions.downAction(this.players.get(1), true));
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true), "DOWN released");
        aMap.put("DOWN released", this.actions.downAction(this.players.get(1), false));
    }

}
