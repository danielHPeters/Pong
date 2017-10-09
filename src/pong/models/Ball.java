package pong.models;

import java.awt.Rectangle;

import pong.interfaces.CollideAble;

/**
 * Describes a ball object, its movement functions etc.
 *
 * @author Daniel Peters
 */
public class Ball extends MovableObject {

  /**
   * Default constructor setting position, speed, width, height.
   *
   * @param x     initial x position
   * @param y     initial y position
   * @param speed ball speed
   */
  public Ball(int x, int y, int speed) {
    this.up = true;
    this.right = false;
    this.location = new Vector2I(x, y);
    this.startLocation = new Vector2I(x, y);
    this.velocity = new Vector2I(2, 1);
    this.acceleration = new Vector2I(1, 1);
    this.maxSpeed = 5;
    this.speed = speed;
    this.width = 8;
    this.height = 8;
  }

  /**
   * Getter for the site of ball.
   *
   * @return current size
   */
  public int getSize() {
    return width;
  }

  /**
   * Setter for the site of ball (width and height).
   *
   * @param size new size
   */
  public void setSize(int size) {
    width = size;
    height = size;
  }

  /**
   * Move the ball.
   */
  @Override
  public void move() {
    location.add(velocity);
  }

  /**
   * Checks for collision with other objects.
   *
   * @param collObj CollideAble Object
   * @return boolean which tells if there was a collision with an object
   */
  @Override
  public boolean collision(CollideAble collObj) {
    boolean coll = false;
    if (collObj.getBounds().intersects(this.getBounds())) {
      coll = true;
    }
    return coll;
  }

  @Override
  public void collisionHandler() {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(location.getX(), location.getY(), width, height);
  }
}
