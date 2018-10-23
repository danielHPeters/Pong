package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector;
import ch.peters.daniel.pong.math.Vector2I;

/**
 * Abstract class which defines movable game objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
abstract class MovableEntity extends Entity implements Movable {
  protected int speed;
  protected int maxSpeed;
  protected Vector<Integer> startLocation;
  protected Vector<Integer> velocity;
  protected Vector<Integer> acceleration;
  protected boolean up;
  protected boolean down;
  protected boolean left;
  protected boolean right;

  @Override
  public int getSpeed() {
    return speed;
  }

  @Override
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  public void setUp(boolean up) {
    this.up = up;
  }

  public void setDown(boolean down) {
    this.down = down;
  }

  public void setLeft(boolean left) {
    this.left = left;
  }

  public void setRight(boolean right) {
    this.right = right;
  }

  @Override
  public void moveUp() {
    location.setY(location.getY() - speed);
  }

  @Override
  public void moveDown() {
    location.setY(location.getY() + speed);
  }

  @Override
  public void moveLeft() {
    location.setX(location.getX() - speed);
  }

  @Override
  public void moveRight() {
    location.setX(location.getX() + speed);
  }

  /**
   * Resets the object to its original coordinates.
   */
  @Override
  public void resetPosition() {
    location.set(startLocation);
    velocity = new Vector2I(1, 1);
  }

  public Vector<Integer> getVelocity() {
    return velocity;
  }

  public Vector<Integer> getAcceleration() {
    return acceleration;
  }
}
