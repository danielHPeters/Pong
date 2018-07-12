package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector;

/**
 * Abstract base class for game objects.
 *
 * @author Daniel Peters
 * @version 1.0
 */
abstract class Entity implements Collideable {
  protected Vector<Integer> location;
  protected int width;
  protected int height;

  @Override
  public Vector getLocation() {
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
   * @param other Collideable Object
   * @return boolean which tells if there was a collision with an object
   */
  @Override
  public boolean collision(Collideable other) {
    return getBounds().getBounds2D().intersects(other.getBounds().getBounds2D());
  }
}
