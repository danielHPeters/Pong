package pong.interfaces;

/**
 * Interface for movable objects.
 *
 * @author d.peters
 */
public interface IMoveAble {

  int getSpeed();

  void setSpeed(int speed);

  void move();

  void moveUp();

  void moveDown();

  void moveLeft();

  void moveRight();

  void resetPosition();
}
