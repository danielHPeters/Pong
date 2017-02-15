package pong;

/**
 *
 * @author d.peters
 */
public class GameLogic {
    
    /**
     * 
     */
    private GameState game;

    /**
     * 
     * @param game 
     */
    public GameLogic(GameState game) {
        this.game = game;
    }

    /**
     * this method updates all the components on the painter area
     */
    public void update() {

        this.game.getPlayers().forEach((pl) -> {

            // move player
            pl.moveVert(this.game.getArea().getHeight());

            // check for collision with ball
            if (this.game.getBall().collision(pl)) {
                this.game.getBall().changeHorDir();
            }

            // if a player reaches the victoryCond condition, the painter will end
            if (pl.hasWon(this.game.getConfig().getVictoryCondition())) {
                game.setPlaying(false);
            }

        });

        if (this.game.getBall().collision(this.game.getArea())) {

            if (this.game.getBall().getY() <= + 10 || this.game.getBall().getY() >= (this.game.getArea().getHeight() - this.game.getBall().getSize())) {
                this.game.getBall().changeVertDir();
            }

        }

        // move the ball
        this.game.getBall().move();

        // check if the ball hit the right border
        if (this.game.getBall().getX() > (this.game.getArea().getWidth() - this.game.getBall().getSize())) {
            this.game.getPlayers().get(0).incrementScore();
            this.game.resetGameObjects();
        }

        // check if the ball hit the left border
        if (this.game.getBall().getX() == 0) {
            this.game.getPlayers().get(1).incrementScore();
            this.game.resetGameObjects();
        }
    }

    

    /**
     * 
     * @return 
     */
    public GameState getGame() {
        return game;
    }
    

}
