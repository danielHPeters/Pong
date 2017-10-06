package pong.models;

import pong.interfaces.IVector2I;
import pong.interfaces.Moveable;

/**
 * Abstract class which defines movable game objects.
 *
 * @author Daniel Peters
 */
abstract class MovableObject extends GameObject implements Moveable {

  /**
   * Movement speed of the object.
   */
  protected int speed;

  /**
   * Initial x position (Used to reset the object to start position).
   */
  protected int initialX;

  /**
   * Initial y position (Used to reset the object to start position).
   */
  protected int initialY;

  protected int maxSpeed;

  protected IVector2I startLocation;

  protected IVector2I velocity;

  protected IVector2I acceleration;

  protected boolean up;

  protected boolean down;

  protected boolean left;

  protected boolean right;

  /**
   * Getter for the object speed.
   *
   * @return the current object speed
   */
  public int getSpeed() {
    return speed;
  }

  /**
   * Setter for the object speed.
   *
   * @param speed new object speed
   */
  public void setSpeed(int speed) {
    this.speed = speed;
  }

  /**
   * Setter for up.
   *
   * @param up new status for up
   */
  public void setUp(boolean up) {
    this.up = up;
  }

  /**
   * Setter for down.
   *
   * @param down new status for down
   */
  public void setDown(boolean down) {
    this.down = down;
  }

  /**
   * Setter for left.
   *
   * @param left new status for left
   */
  public void setLeft(boolean left) {
    this.left = left;
  }

  /**
   * Setter for right.
   *
   * @param right new status for right
   */
  public void setRight(boolean right) {
    this.right = right;
  }

  /**
   * Move object up with its own speed.
   */
  @Override
  public void moveUp() {
    this.y -= speed;
  }

  /**
   * Move object down with its own speed.
   */
  @Override
  public void moveDown() {
    this.y += speed;
  }

  /**
   * Move object left with its own speed.
   */
  @Override
  public void moveLeft() {
    this.x -= speed;
  }

  /**
   * Move object right with its own speed.
   */
  @Override
  public void moveRight() {
    this.x += speed;
  }

  /**
   * Resets the object to its original coordinates.
   */
  @Override
  public void resetPosition() {
    this.location.set(this.startLocation);
    this.velocity = new Vector2I(1, 1);
    this.x = initialX;
    this.y = initialY;
  }

  public IVector2I getLocation() {
    return location;
  }

  public IVector2I getVelocity() {
    return velocity;
  }

  public IVector2I getAcceleration() {
    return acceleration;
  }
}
