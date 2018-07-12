package ch.peters.daniel.pong.models;

import ch.peters.daniel.pong.math.Vector2I;

import java.awt.Rectangle;
import java.awt.Shape;

/**
 * Definition of the player object.
 *
 * @author Daniel Peters
 */
public class Player extends MovableEntity {
  private int score = 0;
  private final Court area;

  /**
   * Default constructor.
   * Initializes the players x and y position as well ad the  width and height.
   *
   * @param posX X position on game area
   * @param posY Y position on game area
   * @param area Pong area where all the other objects are contained
   */
  public Player(int posX, int posY, int speed, Court area) {
    this.startLocation = new Vector2I(posX, posY);
    this.location = new Vector2I(posX, posY);
    this.up = false;
    this.down = false;
    this.speed = speed;
    this.width = 5;
    this.height = 40;
    this.area = area;
  }

  public int getScore() {
    return score;
  }

  public void incrementScore() {
    this.score += 1;
  }

  public void resetScore() {
    this.score = 0;
  }

  /**
   * Check if the player has won the game.
   *
   * @param victoryCondition The amount of scores required to win
   * @return Boolean which tells the game whether the player has won
   */
  public boolean hasWon(int victoryCondition) {
    return this.score == victoryCondition;
  }

  @Override
  public void move() {
    if (up && location.getY() - 10 >= 0) {
      moveUp();
    }

    if (down && location.getY() < area.getHeight() - height) {
      moveDown();
    }
  }

  @Override
  public Shape getBounds() {
    return new Rectangle(location.getX(), location.getY(), width, height);
  }
}
