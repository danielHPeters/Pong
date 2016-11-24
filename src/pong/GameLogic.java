/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.ArrayList;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;
import pong.uiElements.Painter;

/**
 *
 * @author d.peters
 */
public class GameLogic {

    private final int victoryCond; // Score required for victoryCond
    private final ArrayList<Player> players;
    private final Ball ball;
    private final Painter painter;

    public GameLogic(ArrayList<Player> players, Ball ball, Painter painter) {
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
            pl.moveVert(painter.getHeight());
            // check for collision with ball
            if (this.ball.collision(pl)) {
                this.ball.changeHorDir();
            }
            // if a player reaches the victoryCond condition, the painter will end
            if (pl.hasWon(this.victoryCond)) {
                painter.setGameOver(true);
            }
        });

        // move the ball
        this.ball.move(painter.getWidth(), painter.getHeight());

        // check if the ball hit the right border
        if (this.ball.getX() > (painter.getWidth() - this.ball.getSize())) {
            this.players.get(0).incrementScore();
        }

        // check if the ball hit the left border
        if (this.ball.getX() == 0) {
            this.players.get(1).incrementScore();
        }
    }
}
