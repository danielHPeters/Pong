package pong.models;

import pong.interfaces.IPoint;

public class Point implements IPoint {
  private int x;
  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public void setX(int x) {
    this.x = x;
  }

  @Override
  public void setY(int y) {
    this.y = y;
  }

  @Override
  public void set(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void set(IPoint point) {
    this.x = point.getX();
    this.y = point.getY();
  }
}
