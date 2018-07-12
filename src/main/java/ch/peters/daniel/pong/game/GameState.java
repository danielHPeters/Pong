package ch.peters.daniel.pong.game;

import java.util.List;
import ch.peters.daniel.pong.configuration.Settings;
import ch.peters.daniel.pong.models.Ball;
import ch.peters.daniel.pong.models.Court;
import ch.peters.daniel.pong.models.Player;

/**
 * PongState interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface GameState {
  List<Player> getPlayers();

  Court getArea();

  Ball getBall();

  boolean isPlaying();

  void setPlaying(boolean playing);

  void pauseToggle();

  boolean isPaused();

  Settings getConfig();

  void resetGameObjects();

  void restart();
}
