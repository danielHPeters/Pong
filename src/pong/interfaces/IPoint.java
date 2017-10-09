package pong.interfaces;

public interface IPoint {
  int getX();

  int getY();

  void setX(int x);

  void setY(int y);

  void set(int x, int y);

  void set(IPoint point);
}
