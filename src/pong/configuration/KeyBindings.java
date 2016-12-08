package pong.configuration;

import enums.Direction;
import pong.gameObjcects.Player;
import java.util.List;
import javax.swing.*;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class KeyBindings {

    private final KeyBoardActions actions;
    private final JPanel panel;
    List<Player> players;

    /**
     * default constructor which initializes the keyboard configs
     *
     * @param panel the game area object
     * @param players the ArrayList with all player objects
     * @param actions
     */
    public KeyBindings(JPanel panel, List<Player> players, KeyBoardActions actions) {
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
        
        for(Direction dir : Direction.values()){
            iMap.put(dir.getKeyStroke(), dir.getText());
        }
        
        /* W key */
        // put the action functions to the map
        aMap.put("W pressed", this.actions.upAction(this.players.get(0), true));
        // Boolean param true for key released
        aMap.put("W released", this.actions.upAction(this.players.get(0), false));

        /* S key */
        aMap.put("S pressed", this.actions.downAction(this.players.get(0), true));
        aMap.put("S released", this.actions.downAction(this.players.get(0), false));

        /* UP Arrow key */
        aMap.put("UP pressed", this.actions.upAction(this.players.get(1), true));
        aMap.put("UP released", this.actions.upAction(this.players.get(1), false));

        /* DOWN Arrow key */
        aMap.put("DOWN pressed", this.actions.downAction(this.players.get(1), true));
        aMap.put("DOWN released", this.actions.downAction(this.players.get(1), false));
    }

}


