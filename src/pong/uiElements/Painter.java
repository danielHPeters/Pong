package pong.uiElements;

import java.awt.*;
import java.util.List;
import javax.swing.*;
import pong.gameObjcects.Ball;
import pong.gameObjcects.GameArea;
import pong.gameObjcects.Player;

public class Painter extends JPanel {

    private boolean gameOver;
    
    private final int width;
    
    private final int height;
    
    private final GameArea area;
    
    private final List<Player> players;
    
    private final Ball ball;

    /**
     * the default constructor
     *
     * @param width
     * @param height
     * @param area
     * @param players
     * @param ball
     */
    public Painter(int width, int height, GameArea area,  List<Player> players, Ball ball) {
        this.gameOver = false;
        this.width = width;
        this.height = height;
        this.area = area;
        this.players = players;
        this.ball = ball;
    }

    /**
     * getter for gameOver boolean (check if the game stopped)
     *
     * @return boolean which tells if the game is over
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     *
     * @param gameOver
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * draws the ball object
     *
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
     *
     * @param g the graphics object of paintcomponent method
     */
    public void drawPlayers(Graphics g) {
        players.forEach((pl) -> {
            g.fillRect(pl.getX(), pl.getY(), pl.getWidth(), pl.getHeight());
        });
    }

    /**
     * draws all texts on the Painter
     *
     * @param g the graphics object of paintcomponent method
     */
    public void drawTexts(Graphics g) {
        //Draw scores
        g.drawString("Player 1: " + players.get(0).getScore(), 25, 10);
        g.drawString("Player 2: " + players.get(1).getScore(), width - 100, 10);
        if (gameOver) {
            g.drawString("Game Over", width / 2 - 20, height / 2 - 20);
        }
    }

    /**
     * Main drawing method
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(area.getX(), area.getY(), area.getWidth(), area.getHeight());
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
    }

}
