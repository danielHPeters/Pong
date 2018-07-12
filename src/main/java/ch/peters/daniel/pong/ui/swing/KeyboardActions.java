package ch.peters.daniel.pong.ui.swing;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.Action;

import ch.peters.daniel.pong.game.GameState;
import ch.peters.daniel.pong.models.Player;

/**
 * Keyboard actions interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface KeyboardActions {
  Action upAction(Player player, boolean toggleUp);

  Action downAction(Player player, boolean toggleDown);

  Action escAction(Window window, GameState game, ScheduledThreadPoolExecutor executor);

  Action restartAction(GameState game);
}
