package pong.interfaces;

import java.awt.Shape;

/**
 * Interface for objects which can collide with other objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface Collideable {
  IVector2I getLocation();

  Shape getBounds();

  boolean collision(Collideable other);
}

