package pong.interfaces;

/**
 * Interface for 2D integer vectors.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface IVector2I {
  int getX();

  void setX(int x);

  int getY();

  void setY(int y);

  void add(IVector2I vector);

  void sub(IVector2I vector);

  void multiply(int scalar);

  void div(int scalar);

  int mag();

  void normalize();

  void limit(int max);

  void set(int x, int y);

  void set(IVector2I vector);
}
