package pong.models;

import pong.interfaces.IVector2I;

/**
 * Basic 2D int vector implementation.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Vector2I implements IVector2I {
  private int x;
  private int y;

  /**
   * Default constructor. Initializes x and y ints.
   *
   * @param x x position
   * @param y y position
   */
  public Vector2I(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void add(IVector2I vector) {
    this.x += vector.getX();
    this.y += vector.getY();
  }

  @Override
  public void sub(IVector2I vector) {
    this.x -= vector.getX();
    this.y -= vector.getY();
  }

  @Override
  public void multiply(int scalar) {
    this.x *= scalar;
    this.y *= scalar;
  }

  @Override
  public void div(int scalar) {
    this.x /= scalar;
    this.y /= scalar;
  }

  @Override
  public int mag() {
    return (int) Math.sqrt(this.x * this.x + this.y * this.y);
  }

  @Override
  public void normalize() {
    var magnitude = mag();
    if (magnitude != 0d) {
      div(magnitude);
    }
  }

  @Override
  public void limit(int max) {
    if (this.mag() > max) {
      this.normalize();
      this.multiply(max);
    }
  }

  @Override
  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void set(IVector2I vector) {
    this.x = vector.getX();
    this.y = vector.getY();
  }
}