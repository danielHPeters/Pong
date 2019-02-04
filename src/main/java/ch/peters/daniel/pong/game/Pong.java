package ch.peters.daniel.pong.game;

/**
 * Pong game logic.
 *
 * @author Daniel Peters
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
      var ballY = gameState.getBall().getLocation().getY();
      var worldTop = 0;
      var worldBottom = gameState.getArea().getHeight() - gameState.getBall().getSize();

      if (ballY == worldTop || ballY > worldBottom) {
        gameState.getBall().getVelocity().setY(-gameState.getBall().getVelocity().getY());
      }
    }

    var ballX = gameState.getBall().getLocation().getX();
    var worldRight = gameState.getArea().getWidth() - gameState.getBall().getSize();
    var worldLeft = 0;

    // check if the ball hit the right border
    if (ballX > worldRight) {
      gameState.getPlayers().get(0).incrementScore();
      gameState.resetGameObjects();
    }

    // check if the ball hit the left border
    if (ballX == worldLeft) {
      gameState.getPlayers().get(1).incrementScore();
      gameState.resetGameObjects();
    }
  }

  @Override
  public GameState getState() {
    return gameState;
  }
}
