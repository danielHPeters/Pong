package pong.models;

/**
 * Point class representing a canvas coordinate.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Point {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public void setX(int x) {
    this.x = x;
  }

  public void setY(int y) {
    this.y = y;
  }

  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public void set(Point point) {
    this.x = point.getX();
    this.y = point.getY();
  }
}
