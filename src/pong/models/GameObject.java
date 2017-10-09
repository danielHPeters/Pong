package pong.models;

import pong.interfaces.CollideAble;
import pong.interfaces.IVector2I;

/**
 * Abstract base class for game objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
abstract class GameObject implements CollideAble {
  protected IVector2I location;
  protected int width;
  protected int height;

  @Override
  public IVector2I getLocation() {
    return location;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  /**
   * Checks for collision with other objects.
   *
   * @param other CollideAble Object
   * @return boolean which tells if there was a collision with an object
   */
  @Override
  public boolean collision(CollideAble other) {
    boolean coll = false;
    if (getBounds().getBounds2D().intersects(other.getBounds().getBounds2D())) {
      coll = true;
    }
    return coll;
  }
}
