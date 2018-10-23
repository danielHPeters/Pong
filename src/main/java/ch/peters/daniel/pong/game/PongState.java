package ch.peters.daniel.pong.game;

import ch.peters.daniel.pong.config.Settings;
import ch.peters.daniel.pong.models.Ball;
import ch.peters.daniel.pong.models.Court;
import ch.peters.daniel.pong.models.Player;

import java.util.Arrays;
import java.util.List;

/**
 * Pong state holding game objects information.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class PongState implements GameState {
  private boolean playing;
  private boolean paused;
  private final Court area;
  private final Ball ball;
  private final Settings config;
  private final List<Player> players;

  /**
   * Creates a new initial game state.
   *
   * @param config Default app settings
   */
  public PongState(Settings config) {
    this.config = config;
    this.area = new Court(config.getWidth() - 10, config.getHeight() - 80);
    this.players = Arrays.asList(
        new Player(2 * 5, area.getHeight() / 2, config.getPlayerSpeed(), area),
        new Player(config.getWidth() - 4 * 5, area.getHeight() / 2, config.getPlayerSpeed(), area)
    );
    this.ball = new Ball(config.getWidth() / 2, config.getHeight() / 2, config.getBallSpeed());
    this.playing = true;
    this.paused = false;
  }

  public List<Player> getPlayers() {
    return players;
  }

  public Court getArea() {
    return area;
  }

  public Ball getBall() {
    return ball;
  }

  public boolean isPlaying() {
    return playing;
  }

  public void setPlaying(boolean playing) {
    this.playing = playing;
  }

  public void pauseToggle() {
    paused = !paused;
  }

  public boolean isPaused() {
    return paused;
  }

  public Settings getConfig() {
    return config;
  }

  public void resetGameObjects() {
    ball.resetPosition();
    players.forEach(player -> player.resetPosition());
  }

  private void resetScores() {
    players.forEach(Player::resetScore);
  }

  /**
   * Restart game.
   */
  public void restart() {
    resetGameObjects();
    resetScores();
    setPlaying(true);
  }
}
