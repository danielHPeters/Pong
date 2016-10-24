package pong.uiElements;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;

public class GameArea extends JPanel {

    private boolean gameOver = false;
    private int dimension;
    private int victoryCond = 6; // Score required for victoryCond
    private Player pl1, pl2;
    public ArrayList<Player> players = new ArrayList<>();
    public Ball ball;

    /**
     * the default constructor
     * @param dim
     */
    public GameArea(int dim) {
        initialize(dim);
    }

    /**
     * getter for gameOver boolean (check if the game stopped)
     * @return boolean which tells if the game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * setter for gameOver boolean
     * @param gameOver new game state
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
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
     * initializes the dimensions of this object and adds all the game objects
     * @param dim the initial game dimensions
     */
    private void initialize(int dim) {
        this.dimension = dim;
        pl1 = new Player(2 * 5, dimension / 2);
        pl2 = new Player(dimension - 4 * 5, dimension / 2);
        players.add(pl1);
        players.add(pl2);
        ball = new Ball(dimension / 2, dimension / 2);
    }

    /**
     * draws the ball object
     * @param g the graphics object of paintcomponent method
     */
    public void drawBall(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
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
        players.forEach((pl) -> {
            // move player
            pl.moveVert(this.getHeight());
            // check for collision with ball
            if (ball.collision(pl)) {
                ball.changeHorDir();
            }
            // if a player reaches the victoryCond condition, the game will end
            if (pl.hasWon(victoryCond)) {
                gameOver = true;
            }
        });
        
        // move the ball
        ball.move(this.getWidth(), this.getHeight());

        // check if the ball hit the right border
        if (ball.getX() > (this.getWidth() - ball.getSize())) {
            players.get(0).incrementScore();
        }

        // check if the ball hit the left border
        if (ball.getX() == 0) {
            players.get(1).incrementScore();
        }
    }
}
