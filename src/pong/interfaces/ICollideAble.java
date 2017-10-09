package pong.interfaces;

import java.awt.Rectangle;

/**
 * Interface for objects which can collide with other objects.
 *
 * @author d.peters
 */
public interface ICollideAble {
  Rectangle getBounds();

  boolean collision(ICollideAble collObj);

  void collisionHandler();
}
