package pong.interfaces;

import java.awt.Rectangle;

/**
 * Interface for objects which can collide with other objects.
 *
 * @author d.peters
 */
public interface CollideAble {
  Rectangle getBounds();

  boolean collision(CollideAble collObj);

  void collisionHandler();
}
