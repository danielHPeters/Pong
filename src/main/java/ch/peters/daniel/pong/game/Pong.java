package ch.peters.daniel.pong.game;

/**
 * Pong game logic.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class Pong implements Game {
  private GameState gameState;

  public Pong(GameState gameState) {
    this.gameState = gameState;
  }

  /**
   * This method updates all the components on the painter area.
   */
  public void update() {
    gameState.getBall().move();
    gameState.getPlayers().forEach(pl -> {
      // move player
      pl.move();

      // check for collision with ball
      if (gameState.getBall().collision(pl)) {
        gameState.getBall().getVelocity().setX(-gameState.getBall().getVelocity().getX());
      }

      // if a player reaches the victoryCond condition, the painter will end
      if (pl.hasWon(gameState.getConfig().getVictoryCondition())) {
        gameState.setPlaying(false);
      }
    });

    if (gameState.getBall().collision(gameState.getArea())) {
      if (gameState.getBall().getLocation().getY() == 0
          || gameState.getBall().getLocation().getY()
          > (gameState.getArea().getHeight() - gameState.getBall().getSize())) {
        gameState.getBall().getVelocity().setY(-gameState.getBall().getVelocity().getY());
      }

    }

    // check if the ball hit the right border
    if (gameState.getBall().getLocation().getX() > (
        gameState.getArea().getWidth() - gameState.getBall().getSize())) {
      gameState.getPlayers().get(0).incrementScore();
      gameState.resetGameObjects();
    }

    // check if the ball hit the left border
    if (gameState.getBall().getLocation().getX() == 0) {
      gameState.getPlayers().get(1).incrementScore();
      gameState.resetGameObjects();
    }
  }

  @Override
  public GameState getState() {
    return gameState;
  }
}
