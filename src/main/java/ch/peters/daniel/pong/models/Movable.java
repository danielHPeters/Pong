package ch.peters.daniel.pong.models;

/**
 * Interface for movable objects.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public interface Movable {
  int getSpeed();

  void setSpeed(int speed);

  void move();

  void moveUp();

  void moveDown();

  void moveLeft();

  void moveRight();

  void resetPosition();
}
