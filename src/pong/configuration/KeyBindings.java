package pong.configuration;

import com.sun.glass.events.KeyEvent;
import pong.enums.Direction;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import pong.GameState;
import pong.uiElements.PongUi;

/**
 * Keyboard configuration of the Game
 *
 * @author d.peters
 */
public class KeyBindings {

    private final PongUi ui;

    /**
     *
     */
    private final ScheduledThreadPoolExecutor executor;

    /**
     *
     */
    private final KeyBoardActions actions;

    /**
     * State of the game and game objects;
     */
    private final GameState game;

    /**
     * default constructor which initializes the keyboard configs
     *
     * @param ui
     * @param executor
     * @param game
     * @param actions
     */
    public KeyBindings(PongUi ui, ScheduledThreadPoolExecutor executor,
            GameState game, KeyBoardActions actions) {
        this.executor = executor;
        this.ui = ui;
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
        InputMap iMap = this.ui.getPainter().getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap aMap = this.ui.getPainter().getActionMap();

        for (Direction dir : Direction.values()) {
            iMap.put(dir.getKeyStroke(), dir.getText());
        }

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC pressed");
        aMap.put("ESC pressed", actions.escAction(this.ui.getWindow(), game, executor));

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
