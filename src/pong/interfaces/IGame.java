package pong.interfaces;

/**
 * Interface for games.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface IGame {
  void update();

  IGameState getState();
}
