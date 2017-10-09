package pong.models;

import pong.interfaces.CollideAble;

/**
 * Game area to used to check if game objects are out of bounds.
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
  public boolean collision(CollideAble collObj) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void collisionHandler() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
