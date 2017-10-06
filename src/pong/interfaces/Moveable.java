package pong.interfaces;

/**
 * Interface for movable objects.
 *
 * @author d.peters
 */
public interface Moveable {
  void move();

  void moveUp();

  void moveDown();

  void moveLeft();

  void moveRight();

  void resetPosition();
}
