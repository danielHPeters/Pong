package pong.uiElements;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;

public class GameArea extends JPanel {

    private boolean gameOver;
    private final int dimension;
    private int victoryCond; // Score required for victoryCond
    private final Player pl1, pl2;
    public ArrayList<Player> players;
    public Ball ball;

    /**
     * the default constructor
     * @param dim
     */
    public GameArea(int dim) {
        this.victoryCond = 6;
        this.gameOver = false;
        this.dimension = dim;
        this.pl1 = new Player(2 * 5, dimension / 2);
        this.pl2 = new Player(dimension - 4 * 5, dimension / 2);
        this.players  = new ArrayList<>();
        this.players.add(pl1);
        this.players.add(pl2);
        this.ball = new Ball(dimension / 2, dimension / 2);
    }

    /**
     * getter for gameOver boolean (check if the game stopped)
     * @return boolean which tells if the game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * getter for the victory condition
     * @return the current victory condition
     */
    public int getVictoryCond() {
        return victoryCond;
    }

    /**
     * setter for the victory condition
     * @param victoryCond new victory condition
     */
    public void setVictoryCond(int victoryCond) {
        this.victoryCond = victoryCond;
    }

    /**
     * getter for the ArrayList with all players
     * @return the the players ArrayList
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * setter for the ArrayList with all players
     * @param players new player ArrayList
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * draws the ball object
     * @param g the graphics object of paintcomponent method
     */
    public void drawBall(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(
                this.ball.getX(), this.ball.getY(),
                this.ball.getSize(), this.ball.getSize()
        );
    }

    /**
     * draws all players
     * @param g the graphics object of paintcomponent method
     */
    public void drawPlayers(Graphics g) {
        players.forEach((pl) -> {
            g.fillRect(pl.getX(), pl.getY(), pl.getWidth(), pl.getHeight());
        });
    }

    /**
     * draws all texts on the GameArea
     * @param g the graphics object of paintcomponent method
     */
    public void drawTexts(Graphics g) {
        //Draw scores
        g.drawString("Player 1: " + players.get(0).getScore(), 25, 10);
        g.drawString("Player 2: " + players.get(1).getScore(), dimension - 100, 10);
        if (gameOver) {
            g.drawString("Game Over", dimension / 2 - 20, dimension / 2);
        }
    }

    /**
     * Main drawing method
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
    }

    /**
     * this method updates all the components on the game area
     */
    public void update() {
        this.players.forEach((pl) -> {
            // move player
            pl.moveVert(this.getHeight());
            // check for collision with ball
            if (this.ball.collision(pl)) {
                this.ball.changeHorDir();
            }
            // if a player reaches the victoryCond condition, the game will end
            if (pl.hasWon(this.victoryCond)) {
                this.gameOver = true;
            }
        });
        
        // move the ball
        this.ball.move(this.getWidth(), this.getHeight());

        // check if the ball hit the right border
        if (this.ball.getX() > (this.getWidth() - this.ball.getSize())) {
            this.players.get(0).incrementScore();
        }

        // check if the ball hit the left border
        if (this.ball.getX() == 0) {
            this.players.get(1).incrementScore();
        }
    }
}
