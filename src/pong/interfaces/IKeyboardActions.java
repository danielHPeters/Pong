package pong.interfaces;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.Action;
import pong.models.Player;

public interface IKeyboardActions {
  Action upAction(Player player, boolean toggleUp);

  Action downAction(Player player, boolean toggleDown);

  Action escAction(IWindow window, IGameState game, ScheduledThreadPoolExecutor executor);

  Action restartAction(IGameState game);
}
