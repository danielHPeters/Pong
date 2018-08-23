package ch.peters.daniel.pong.game;

/**
 * Interface for games.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public interface Game {
  void update();

  GameState getState();
}
