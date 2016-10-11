package pong;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    
    private boolean playing;
    private int victoryCond = 6; // Score required for victoryCond
    private int gameSpeed = 50;
    private int paddleW = 5, paddleH = 30;
    Paddle playerOne = new Paddle(10, 100, paddleW, paddleH, 1);
    Paddle playerTwo = new Paddle(225, 100, paddleW, paddleH, 2);
    Ball ball = new Ball(100, 100);

    public boolean isPlaying() {
        return playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    public int getVictory() {
        return victoryCond;
    }

    public void setVictory(int victory) {
        this.victoryCond = victory;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public int getPaddleW() {
        return paddleW;
    }

    public void setPaddleW(int paddleW) {
        this.paddleW = paddleW;
    }

    public int getPaddleH() {
        return paddleH;
    }

    public void setPaddleH(int paddleH) {
        this.paddleH = paddleH;
    }
    
    public void drawBall(Graphics g){
        g.setColor(Color.black);
        g.fillOval(ball.getX(), ball.getY(), ball.getSize(), ball.getSize());
    }
    
    public void drawPlayers(Graphics g){
        g.fillRect(
                (int) playerOne.getX(), (int) playerOne.getY(),
                (int) playerOne.getWidth(), (int) playerOne.getHeight()
        );
        g.fillRect(
                (int) playerTwo.getX(), (int) playerTwo.getY(),
                (int) playerTwo.getWidth(), (int) playerTwo.getHeight()
        );
    }
    
    public void drawTexts(Graphics g){
        //Draw scores
        g.drawString("Player 1: " + playerOne.getScore(), 25, 10);
        g.drawString("Player 2: " + playerTwo.getScore(), 150, 10);
        if (!playing) {
            g.drawString("Game Over", 100, 125);
        }
    }

    // Draw ball and ships
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
        repaint();
    }

    public void gameLoop() {
        while (playing) {
            /**
             * Delay the game loop (otherwise the game will instantly end)
             * the duration of the delay also determines the speed of the game
             * 
             */
            try {
                Thread.sleep(gameSpeed);
            } catch (InterruptedException ex) {

            }
            
            // Move the ball horizontally
            ball.moveHor(this.getWidth());
            
            // Move the ball vertically
            ball.moveVert(this.getHeight());
            
            // Moving players
            playerOne.move(this.getHeight());
            playerTwo.move(this.getHeight());

            // check if the ball hit the right border
            if (ball.getX() >= (this.getWidth() - ball.getSize())) {
                playerOne.incrementScore();
            }

            // check if the ball hit the left border
            if (ball.getX() == 0) {
                playerTwo.incrementScore();
            }

            // if a player reaches the victoryCond condition, the game will end
            if (playerOne.hasWon(victoryCond) || playerTwo.hasWon(victoryCond)) {
                playing = false;
            }

            // check if playerOne deflected the ball
            if(playerOne.deflectedBall(ball.getX(), ball.getY())){
                ball.moveRight(true);
            }
            
            // check if playerTwo deflected the ball
            if(playerTwo.deflectedBall(ball.getX(), ball.getY())){
                ball.moveRight(false);
            }
        }
    }

    /**
     * Start the game loop
     */
    @Override
    public void run() {
        gameLoop();
    }
}
