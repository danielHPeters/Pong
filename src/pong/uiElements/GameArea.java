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
     *
     * @param dim
     */
    public GameArea(int dim) {
        initialize(dim);
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
    /**
     *
     * @return
     */
    public int getVictoryCond() {
        return victoryCond;
    }

    /**
     *
     * @param victoryCond
     */
    public void setVictoryCond(int victoryCond) {
        this.victoryCond = victoryCond;
    }

    /**
     *
     * @return
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }
    
    /**
     *
     * @param dim
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
     *
     * @param g
     */
    public void drawBall(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
    }

    /**
     *
     * @param g
     */
    public void drawPlayers(Graphics g) {
        players.forEach((pl) -> {
            g.fillRect(pl.getX(), pl.getY(), pl.getWidth(), pl.getHeight());
        });
    }

    /**
     *
     * @param g
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
     *
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
    }

    /**
     * the game loop which changes the objects according to events
     */
    public void update() {

        // Move the ball horizontally
        ball.move(this.getWidth(), this.getHeight());
        // Moving players
        players.forEach((pl) -> {
            pl.moveVert(this.getHeight());
        });

        // Check for collision with players
        if (ball.collision(players)) {
            ball.changeVertDir();
        }

        // check if the ball hit the right border
        if (ball.getX() > (this.getWidth() - ball.getSize())) {
            players.get(0).incrementScore();
        }

        // check if the ball hit the left border
        if (ball.getX() == 0) {
            players.get(1).incrementScore();
        }

        // if a player reaches the victoryCond condition, the game will end
        players.forEach((pl) -> {
            if (pl.hasWon(victoryCond)) {
                gameOver = true;
            }
        });
    }
}
