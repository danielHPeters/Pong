package ch.peters.daniel.pong.game;

import ch.peters.daniel.pong.config.Settings;
import ch.peters.daniel.pong.models.Ball;
import ch.peters.daniel.pong.models.Court;
import ch.peters.daniel.pong.models.Player;

import java.util.List;

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
