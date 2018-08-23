package ch.peters.daniel.pong.action;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.Action;

import ch.peters.daniel.pong.game.GameState;
import ch.peters.daniel.pong.models.Player;
import ch.peters.daniel.pong.ui.swing.Window;

/**
 * Keyboard actions interface.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public interface KeyboardActions {
  Action upAction(Player player, boolean toggleUp);

  Action downAction(Player player, boolean toggleDown);

  Action quitAction(Window window, GameState game, ScheduledThreadPoolExecutor executor);

  Action restartAction(GameState game);
}
