package pong;

import java.util.List;
import pong.gameObjcects.Ball;
import pong.gameObjcects.GameArea;
import pong.gameObjcects.Player;
import pong.uiElements.Painter;

/**
 *
 * @author d.peters
 */
public class GameLogic {

    /**
     * Score required for victory
     */
    private final int victoryCond;

    private final GameArea area;

    private final List<Player> players;

    private final Ball ball;

    private final Painter painter;

    /**
     *
     * @param area
     * @param players
     * @param ball
     * @param painter
     */
    public GameLogic(GameArea area, List<Player> players, Ball ball, Painter painter) {
        this.area = area;
        this.players = players;
        this.ball = ball;
        this.painter = painter;
        this.victoryCond = 6;
    }

    /**
     * this method updates all the components on the painter area
     */
    public void update() {

        this.players.forEach((pl) -> {

            // move player
            pl.moveVert(area.getHeight());

            // check for collision with ball
            if (this.ball.collision(pl)) {
                this.ball.changeHorDir();
            }

            // if a player reaches the victoryCond condition, the painter will end
            if (pl.hasWon(this.victoryCond)) {
                painter.setGameOver(true);
            }

        });

        if (this.ball.collision(area)) {

            if (ball.getY() <= 0 || ball.getY() >= (area.getWidth() - ball.getSize())) {
                ball.changeVertDir();
            }

        }

        // move the ball
        this.ball.move();

        // check if the ball hit the right border
        if (this.ball.getX() > (area.getWidth() - this.ball.getSize())) {
            this.players.get(0).incrementScore();
            reseGameObjects();
        }

        // check if the ball hit the left border
        if (this.ball.getX() == 0) {
            this.players.get(1).incrementScore();
            reseGameObjects();
        }
    }

    public void reseGameObjects() {
        this.ball.resetPosition();
        this.players.forEach(player -> player.resetPosition());
    }

    public void resetScores() {
        this.players.forEach(player -> player.resetScore());
    }

}
