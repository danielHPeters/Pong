package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector2I;

import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Pong area to used to check if game objects are out of getBounds.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class Court extends Entity {
  /**
   * Default constructor. Sets position and dimension of game area.
   *
   * @param width  area width
   * @param height area height
   */
  public Court(int width, int height) {
    this.location = new Vector2I(0, 0);
    this.width = width;
    this.height = height;
  }

  @Override
  public Shape getBounds() {
    return new Rectangle(location.getX(), location.getY(), width, height);
  }
}
