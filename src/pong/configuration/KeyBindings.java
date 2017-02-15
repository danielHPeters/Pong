package pong.configuration;

import com.sun.glass.events.KeyEvent;
import pong.enums.Direction;
import pong.models.Player;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.*;
import pong.GameState;
import pong.RunGame;
import pong.uiElements.GameWindow;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class KeyBindings {

    /**
     * 
     */
    private final GameWindow window;
    
    /**
     * 
     */
    private final JPanel panel;
    
    /**
     * 
     */
    private final ScheduledThreadPoolExecutor executor;
    
    /**
     * 
     */
    private final KeyBoardActions actions;
    
    private final GameState game;

    /**
     * default constructor which initializes the keyboard configs
     *
     * @param window
     * @param panel the game area object
     * @param executor
     * @param actions
     */
    public KeyBindings(GameWindow window, JPanel panel,
            ScheduledThreadPoolExecutor executor, GameState game, KeyBoardActions actions) {
        this.executor = executor;
        this.window = window;
        this.panel = panel;
        this.actions = actions;
        this.game = game;
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
        
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC pressed");
        aMap.put("ESC pressed", actions.escAction(window, game, executor));
        
        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R pressed");
        aMap.put("R pressed", actions.restartAction(game));
        
        /* W key */
        // put the action functions to the map
        aMap.put("W pressed", this.actions.upAction(this.game.getPlayers().get(0), true));
        // Boolean param true for key released
        aMap.put("W released", this.actions.upAction(this.game.getPlayers().get(0), false));

        /* S key */
        aMap.put("S pressed", this.actions.downAction(this.game.getPlayers().get(0), true));
        aMap.put("S released", this.actions.downAction(this.game.getPlayers().get(0), false));

        /* UP Arrow key */
        aMap.put("UP pressed", this.actions.upAction(this.game.getPlayers().get(1), true));
        aMap.put("UP released", this.actions.upAction(this.game.getPlayers().get(1), false));

        /* DOWN Arrow key */
        aMap.put("DOWN pressed", this.actions.downAction(this.game.getPlayers().get(1), true));
        aMap.put("DOWN released", this.actions.downAction(this.game.getPlayers().get(1), false));
    }

}


