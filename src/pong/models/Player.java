package pong.models;

import pong.interfaces.ICollideAble;

/**
 * Definition of the player object.
 *
 * @author Daniel Peters
 */
public class Player extends MovableObject {
  private int score = 0;
  private final GameArea area;

  /**
   * Default constructor.
   * Initializes the players x and y position as well ad the  width and height.
   *
   * @param posX X position on game area
   * @param posY Y position on game area
   * @param area game area where all the other objects are contained
   */
  public Player(int posX, int posY, int speed, GameArea area) {
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
   * @param victoryCondition the amount of scores required to win
   * @return boolean which tells the game whether the player has won
   */
  public boolean hasWon(int victoryCondition) {
    boolean isWinner = false;
    if (this.score == victoryCondition) {
      isWinner = true;
    }
    return isWinner;
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
  public boolean collision(ICollideAble collObj) {
    throw new UnsupportedOperationException("Not supported yet.");
  }

  @Override
  public void collisionHandler() {
    throw new UnsupportedOperationException("Not supported yet.");
  }
}
