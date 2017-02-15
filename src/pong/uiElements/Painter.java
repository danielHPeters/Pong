package pong.uiElements;

import java.awt.*;
import javax.swing.*;
import pong.GameState;
import pong.configuration.Settings;

public class Painter extends JPanel {

    private Settings config;

    /**
     *
     */
    private final GameState game;

    /**
     * 
     * @param config
     * @param game 
     */
    public Painter(Settings config, GameState game) {
        this.config = config;
        this.game = game;
    }

    /**
     * draws the ball object
     *
     * @param g the graphics object of paintcomponent method
     */
    public void drawBall(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(
                this.game.getBall().getX(), this.game.getBall().getY(),
                this.game.getBall().getSize(), this.game.getBall().getSize()
        );
    }

    /**
     * draws all players
     *
     * @param g the graphics object of paintcomponent method
     */
    public void drawPlayers(Graphics g) {
        this.game.getPlayers().forEach((pl) -> {
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
        g.drawString(
                "Player 1: " + this.game.getPlayers().get(0).getScore(),
                25, 10
        );
        g.drawString(
                "Player 2: " + this.game.getPlayers().get(1).getScore(),
                this.config.getWidth() - 100, 10
        );
        if (!this.game.isPlaying()) {
            g.drawString("Game Over", this.config.getWidth() / 2 - 20, this.config.getHeight() / 2 - 20);
        }
    }

    /**
     * Main drawing method
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(
                this.game.getArea().getX(),
                this.game.getArea().getY(),
                this.game.getArea().getWidth(),
                this.game.getArea().getHeight()
        );
        drawBall(g);
        drawPlayers(g);
        drawTexts(g);
    }

}
