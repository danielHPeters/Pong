package pong.models;

import java.awt.Rectangle;

import pong.interfaces.CollideAble;
import pong.interfaces.IVector2I;

/**
 * Abstract base class for game objects.
 *
 * @author Daniel Peters
 */
abstract class GameObject implements CollideAble {
  /**
   * Object location.
   */
  protected IVector2I location;

  /**
   * Width.
   */
  protected int width;

  /**
   * Height.
   */
  protected int height;

  /**
   * Position x.
   */
  protected int x;

  /**
   * Position y.
   */
  protected int y;

  /**
   * Getter for object width.
   *
   * @return current width
   */
  public int getWidth() {
    return width;
  }

  /**
   * Getter for object height.
   *
   * @return current object height
   */
  public int getHeight() {
    return height;
  }

  /**
   * Getter for x position.
   *
   * @return current x position of the object
   */
  public int getX() {
    return x;
  }

  /**
   * Setter for x position.
   *
   * @param x new x position
   */
  public void setX(int x) {
    this.x = x;
  }

  /**
   * Getter for y position.
   *
   * @return the current y position of the object
   */
  public int getY() {
    return y;
  }

  /**
   * Setter for y positon.
   *
   * @param y new y position
   */
  public void setY(int y) {
    this.y = y;
  }

  /**
   * Returns bounding rectangle for collision detection.
   *
   * @return bounding rectangle of the object
   */
  @Override
  public Rectangle getBounds() {
    return new Rectangle(x, y, width, height);
  }
}
