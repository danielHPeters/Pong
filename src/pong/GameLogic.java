package pong;

/**
 * Game logic data.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class GameLogic {
  private GameState state;

  public GameLogic(GameState state) {
    this.state = state;
  }

  /**
   * This method updates all the components on the painter area.
   */
  public void update() {

    state.getBall().move();
    state.getPlayers().forEach(pl -> {
      // move player
      pl.move();

      // check for collision with ball
      if (state.getBall().collision(pl)) {
        state.getBall().getVelocity().setX(-state.getBall().getVelocity().getX());
      }

      // if a player reaches the victoryCond condition, the painter will end
      if (pl.hasWon(state.getConfig().getVictoryCondition())) {
        state.setPlaying(false);
      }
    });

    if (this.state.getBall().collision(state.getArea())) {
      if (state.getBall().getLocation().getY() == 0
          || state.getBall().getLocation().getY()
          > (state.getArea().getHeight() - state.getBall().getSize())) {
        state.getBall().getVelocity().setY(-state.getBall().getVelocity().getY());
      }

    }

    // check if the ball hit the right border
    if (state.getBall().getLocation().getX() > (
        state.getArea().getWidth() - state.getBall().getSize())) {
      state.getPlayers().get(0).incrementScore();
      state.resetGameObjects();
    }

    // check if the ball hit the left border
    if (state.getBall().getLocation().getX() == 0) {
      state.getPlayers().get(1).incrementScore();
      state.resetGameObjects();
    }
  }

  public GameState getState() {
    return state;
  }
}
