package pong.ui.swing;

import com.sun.glass.events.KeyEvent;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import pong.enums.Direction;
import pong.interfaces.IGameState;
import pong.interfaces.IKeyBindings;
import pong.interfaces.IKeyboardActions;
import pong.interfaces.IUi;

/**
 * Keyboard configuration of the Game.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingKeyBindings implements IKeyBindings {
  private final IUi ui;
  private final ScheduledThreadPoolExecutor executor;
  private final IKeyboardActions actions;
  private final IGameState game;

  /**
   * Default constructor which initializes the keyboard configs.
   *
   * @param ui       user interface
   * @param executor scheduled thread pool executor
   * @param game     game state
   * @param actions  keyboard actions
   */
  public SwingKeyBindings(IUi ui, ScheduledThreadPoolExecutor executor, IGameState game, IKeyboardActions actions) {
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
    InputMap inMap = ((JPanel) ui.getCanvas()).getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
    ActionMap acMap = ((JPanel) ui.getCanvas()).getActionMap();

    for (Direction dir : Direction.values()) {
      inMap.put(dir.getKeyStroke(), dir.getText());
    }

    inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC pressed");
    acMap.put("ESC pressed", actions.escAction(ui.getWindow(), game, executor));

    inMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R pressed");
    acMap.put("R pressed", actions.restartAction(game));

    // W key
    acMap.put("W pressed", actions.upAction(game.getPlayers().get(0), true));
    acMap.put("W released", actions.upAction(game.getPlayers().get(0), false));

    // S key
    acMap.put("S pressed", actions.downAction(game.getPlayers().get(0), true));
    acMap.put("S released", actions.downAction(game.getPlayers().get(0), false));

    // UP Arrow key
    acMap.put("UP pressed", actions.upAction(game.getPlayers().get(1), true));
    acMap.put("UP released", actions.upAction(game.getPlayers().get(1), false));

    // DOWN Arrow key
    acMap.put("DOWN pressed", actions.downAction(game.getPlayers().get(1), true));
    acMap.put("DOWN released", actions.downAction(game.getPlayers().get(1), false));
  }
}
