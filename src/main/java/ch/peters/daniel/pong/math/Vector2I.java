package ch.peters.daniel.pong.math;

/**
 * Basic 2D int vector implementation.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Vector2I implements Vector<Integer> {
  private Integer x;
  private Integer y;

  /**
   * Default constructor. Initializes x and y ints.
   *
   * @param x x position
   * @param y y position
   */
  public Vector2I(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public void setX(Integer x) {
    this.x = x;
  }

  @Override
  public int getY() {
    return this.y;
  }

  @Override
  public void setY(Integer y) {
    this.y = y;
  }

  @Override
  public void add(Vector vector) {
    this.x += vector.getX();
    this.y += vector.getY();
  }

  @Override
  public void sub(Vector vector) {
    this.x -= vector.getX();
    this.y -= vector.getY();
  }

  @Override
  public void multiply(Integer scalar) {
    this.x *= scalar;
    this.y *= scalar;
  }

  @Override
  public void div(Integer scalar) {
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
  public void limit(Integer max) {
    if (this.mag() > max) {
      this.normalize();
      this.multiply(max);
    }
  }

  @Override
  public void set(Integer x, Integer y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void set(Vector vector) {
    this.x = vector.getX();
    this.y = vector.getY();
  }
}