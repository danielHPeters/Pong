package pong.uiElements;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;

public class GamePanel extends JPanel implements Runnable {

    private boolean playing;
    private int dimension;
    private int victoryCond = 6; // Score required for victoryCond
    private int gameSpeed = 30; // The lower, the faster the game
    public Player pl1;
    public Player pl2;
    public ArrayList<Player> players = new ArrayList<>();
    public Ball ball;

    /**
     * 
     * @param dim 
     */
    public GamePanel(int dim) {
        initialize(dim);
    }
    
    /**
     * 
     * @param dim 
     */
    private void initialize(int dim){
        this.dimension = dim;
        pl1 = new Player(2 * 5, dimension / 2, 1);
        pl2 = new Player(dimension - 4 * 5, dimension / 2, 2);
        players.add(pl1);
        players.add(pl2);
        ball = new Ball(dimension / 2, dimension / 2);
    }

    /**
     * 
     * @return 
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     * 
     * @param playing 
     */
    public void setPlaying(boolean playing) {
        this.playing = playing;
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
    public int getGameSpeed() {
        return gameSpeed;
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
     * @param gameSpeed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
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
        g.fillRect(pl1.getX(), pl1.getY(), pl1.getWidth(), pl1.getHeight());
        g.fillRect(pl2.getX(), pl2.getY(), pl2.getWidth(), pl2.getHeight());
    }

    /**
     *
     * @param g
     */
    public void drawTexts(Graphics g) {
        //Draw scores
        g.drawString("Player 1: " + pl1.getScore(), 25, 10);
        g.drawString("Player 2: " + pl2.getScore(), dimension - 100, 10);
        if (!playing) {
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
    public void gameLoop() {
        while (playing) {
            /**
             * Delay the game loop (otherwise the game will instantly end) the
             * duration of the delay also determines the speed of the game
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
            pl1.moveVert(this.getHeight());
            pl2.moveVert(this.getHeight());
            
            if (ball.collision(pl1, pl2)){
                ball.changeVertDir();
            }

            // check if the ball hit the right border
            if (ball.getX() > (this.getWidth() - ball.getSize())) {
                pl1.incrementScore();
            }

            // check if the ball hit the left border
            if (ball.getX() == 0) {
                pl2.incrementScore();
            }

            // if a player reaches the victoryCond condition, the game will end
            if (pl1.hasWon(victoryCond) || pl2.hasWon(victoryCond)) {
                playing = false;
            }

            repaint();
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
