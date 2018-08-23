package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector;

import java.awt.Shape;

/**
 * Interface for objects which can collide with other objects.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public interface Collideable {
  Vector getLocation();

  Shape getBounds();

  boolean collision(Collideable other);
}

