package ch.peters.daniel.pong.ui.swing;

import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.AbstractAction;
import javax.swing.Action;

import ch.peters.daniel.pong.game.GameState;
import ch.peters.daniel.pong.models.Player;

/**
 * Definitions of keyboard actions.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingKeyboardActions implements KeyboardActions {
  /**
   * This method creates the methods for the up actions.
   *
   * @param player   The player object
   * @param toggleUp Boolean which is true for key pressed and for for key released
   * @return The abstract action
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
   * @param player     The player object
   * @param toggleDown Boolean which is true for key pressed and for for key released
   * @return The abstract action
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
   * @param window   Main window frame
   * @param game     Pong state
   * @param executor Thread pool executor
   * @return Escape action
   */
  @Override
  public Action escAction(Window window, GameState game, ScheduledThreadPoolExecutor executor) {
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
   * @param game Pong state
   * @return Restart action
   */
  @Override
  public Action restartAction(GameState game) {
    return new AbstractAction() {
      @Override
      public void actionPerformed(ActionEvent e) {
        game.restart();
      }
    };
  }
}
