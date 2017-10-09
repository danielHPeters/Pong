package pong.interfaces;

import java.awt.Shape;

/**
 * Interface for objects which can collide with other objects.
 *
 * @author d.peters
 */
public interface CollideAble {
  IVector2I getLocation();

  Shape getBounds();

  boolean collision(CollideAble other);
}
