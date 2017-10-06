package pong.configuration;

import com.sun.glass.events.KeyEvent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import pong.GameState;
import pong.enums.Direction;
import pong.interfaces.IUi;

/**
 * Keyboard configuration of the Game.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class KeyBindings {

  /**
   * Reference to the main UI.
   */
  private final IUi ui;

  /**
   * Thread executor which restarts main thread after pause.
   */
  private final ScheduledThreadPoolExecutor executor;

  /**
   * Actions executed on specific keyboard events.
   */
  private final KeyBoardActions actions;

  /**
   * State of the game and game objects.
   */
  private final GameState game;

  /**
   * default constructor which initializes the keyboard configs.
   *
   * @param ui user interface
   * @param executor scheduled thread pool executor
   * @param game game state
   * @param actions keyboard actions
   */
  public KeyBindings(IUi ui, ScheduledThreadPoolExecutor executor,
                     GameState game, KeyBoardActions actions) {
    this.executor = executor;
    this.ui = ui;
    this.actions = actions;
    this.game = game;
    initialize();
  }

  /**
   * Initialization method which binds keys to action methods.
   */
  private void initialize() {
    // Get the input map of the GamePanel
    InputMap inMap = ((JPanel) this.ui.getCanvas()).getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    ActionMap acMap = ((JPanel) this.ui.getCanvas()).getActionMap();

    for (Direction dir : Direction.values()) {
      inMap.put(dir.getKeyStroke(), dir.getText());
    }

    inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC pressed");
    acMap.put("ESC pressed", actions.escAction(this.ui.getWindow(), game, executor));

    inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R pressed");
    acMap.put("R pressed", actions.restartAction(game));

    // W key
    acMap.put("W pressed", this.actions.upAction(this.game.getPlayers().get(0), true));
    acMap.put("W released", this.actions.upAction(this.game.getPlayers().get(0), false));

    // S key
    acMap.put("S pressed", this.actions.downAction(this.game.getPlayers().get(0), true));
    acMap.put("S released", this.actions.downAction(this.game.getPlayers().get(0), false));

    // UP Arrow key
    acMap.put("UP pressed", this.actions.upAction(this.game.getPlayers().get(1), true));
    acMap.put("UP released", this.actions.upAction(this.game.getPlayers().get(1), false));

    // DOWN Arrow key
    acMap.put("DOWN pressed", this.actions.downAction(this.game.getPlayers().get(1), true));
    acMap.put("DOWN released", this.actions.downAction(this.game.getPlayers().get(1), false));
  }

}
