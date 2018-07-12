package ch.peters.daniel.pong.math;

/**
 * Interface for 2D integer vectors.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public interface Vector<T> {
  int getX();

  void setX(T x);

  int getY();

  void setY(T y);

  void add(Vector vector);

  void sub(Vector vector);

  void multiply(T scalar);

  void div(T scalar);

  int mag();

  void normalize();

  void limit(T max);

  void set(T x, T y);

  void set(Vector vector);
}
