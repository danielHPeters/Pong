package pong.models;

import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Game area to used to check if game objects are out of getBounds.
 *
 * @author Daniel Peters
 */
public class GameArea extends GameObject {
  /**
   * Default constructor. Sets position and dimension of game area.
   *
   * @param width  area width
   * @param height area height
   */
  public GameArea(int width, int height) {
    this.location = new Vector2I(0, 0);
    this.width = width;
    this.height = height;
  }

  @Override
  public Shape getBounds() {
    return new Rectangle(location.getX(), location.getY(), width, height);
  }
}
