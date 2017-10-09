package pong.ui.swing;

import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.AbstractAction;
import javax.swing.Action;

import pong.interfaces.IGameState;
import pong.interfaces.IKeyboardActions;
import pong.interfaces.IWindow;
import pong.models.Player;

/**
 * Definitions of keyboard actions.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingKeyboardActions implements IKeyboardActions {
  /**
   * This method creates the methods for the up actions.
   *
   * @param player   the player object
   * @param toggleUp boolean which is true for key pressed and for for key released
   * @return the abstract action
   */
  @Override
  public Action upAction(Player player, boolean toggleUp) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        player.setUp(toggleUp);
      }

    };
  }

  /**
   * This method creates the methods for the down actions.
   *
   * @param player     the player object
   * @param toggleDown boolean which is true for key pressed and for for key released
   * @return the abstract action
   */
  @Override
  public Action downAction(Player player, boolean toggleDown) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        player.setDown(toggleDown);
      }

    };
  }

  /**
   * Action that stops the application thread and closes the GUI.
   *
   * @param window   main window frame
   * @param game     game state
   * @param executor thread pool executor
   * @return escape action
   */
  @Override
  public Action escAction(IWindow window, IGameState game, ScheduledThreadPoolExecutor executor) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.setPlaying(false);
        executor.shutdown();
        window.close();
      }
    };
  }

  /**
   * Restart action.
   *
   * @param game game state
   * @return restart action
   */
  @Override
  public Action restartAction(IGameState game) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.restart();
      }
    };
  }

}
