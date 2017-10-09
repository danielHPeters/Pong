package pong.models;

import java.awt.Rectangle;

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

  public IVector2I getLocation() {
    return location;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  @Override
  public Rectangle getBounds() {
    return new Rectangle(location.getX(), location.getY(), width, height);
  }
}
