package ch.peters.daniel.pong.action;

import ch.peters.daniel.pong.game.GameState;
import ch.peters.daniel.pong.models.Player;
import ch.peters.daniel.pong.ui.swing.Window;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.Action;

/**
 * Keyboard actions interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface KeyboardActions {
  Action upAction(Player player, boolean toggleUp);

  Action downAction(Player player, boolean toggleDown);

  Action quitAction(Window window, GameState game, ScheduledThreadPoolExecutor executor);

  Action restartAction(GameState game);
}
