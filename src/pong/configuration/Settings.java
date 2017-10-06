package pong.configuration;

/**
 * Application settings.
 *
 * @author Daniel Peters
 */
public class Settings {

  private int width;

  private int height;

  private int victoryCondition;

  private int ballSpeed;

  private int playerSpeed;

  /**
   * Default constructor. Initializes all game setting.
   *
   * @param width            window width
   * @param height           window height
   * @param victoryCondition required score to win a match
   * @param ballSpeed        speed of the ball
   * @param playerSpeed      speed of the players
   */
  public Settings(int width, int height, int victoryCondition, int ballSpeed, int playerSpeed) {
    this.width = width;
    this.height = height;
    this.victoryCondition = victoryCondition;
    this.ballSpeed = ballSpeed;
    this.playerSpeed = playerSpeed;
  }

  public int getWidth() {
    return width;
  }

  public int getHeight() {
    return height;
  }

  public int getVictoryCondition() {
    return victoryCondition;
  }

  public int getBallSpeed() {
    return ballSpeed;
  }

  public int getPlayerSpeed() {
    return playerSpeed;
  }
}
