package ch.peters.daniel.pong.math

import spock.lang.Specification

class Vector2ITest extends Specification {
  def 'add should add values of other vector' () {
    given:
    def vector = new Vector2I(10, 10)

    when:
    vector.add(new Vector2I(40, 60))

    then:
    vector.getX() == 50
    vector.getY() == 70
  }

  def 'subtract should subtract values of other vector' () {
    given:
    def vector = new Vector2I(10, 10)

    when:
    vector.sub(new Vector2I(40, 60))

    then:
    vector.getX() == -30
    vector.getY() == -50
  }

  def 'multiply should multiply x and y by scalar value' () {
    given:
    def x = 10
    def y = 10
    def vector = new Vector2I(x, y)
    def scalar = 40

    when:
    vector * scalar

    then:
    vector.getX() == x * scalar
    vector.getY() == y * scalar
  }

  def 'div should divide x and y by scalar value' () {
    given:
    def x = 10
    def y = 10
    def vector = new Vector2I(x, y)
    def scalar = 40

    when:
    vector / scalar

    then:
    vector.getX() == (x / scalar) as Integer
    vector.getY() == (y / scalar) as Integer
  }

  def 'mag should return the correct magnitude of a vector' () {
    given:
    def x = 10
    def y = 10
    def vector = new Vector2I(x, y)
    def scalar = 40

    when:
    def magnitude = vector.mag()

    then:
    magnitude == Math.sqrt(x * x + y * y) as Integer
  }
}
