package pong.interfaces;

import java.util.List;
import pong.configuration.Settings;
import pong.models.Ball;
import pong.models.GameArea;
import pong.models.Player;

/**
 * GameState interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface IGameState {
  List<Player> getPlayers();

  GameArea getArea();

  Ball getBall();

  boolean isPlaying();

  void setPlaying(boolean playing);

  void pauseToggle();

  boolean isPaused();

  Settings getConfig();

  void resetGameObjects();

  void restart();
}
