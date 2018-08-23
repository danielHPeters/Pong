package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector2I;

import java.awt.Shape;
import java.awt.geom.Ellipse2D;

/**
 * Describes a ball object, its movement functions etc.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class Ball extends MovableEntity {
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

  @Override
  public Shape getBounds() {
    return new Ellipse2D.Double(location.getX(), location.getY(), width, height);
  }
}
