package pong.ui;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import pong.GameState;
import pong.configuration.Settings;
import pong.interfaces.ICanvas;

public class SwingCanvas extends JPanel implements ICanvas {
  private Settings config;
  private final GameState game;

  /**
   * Default constructor.
   *
   * @param config default setting
   * @param game   game state
   */
  public SwingCanvas(Settings config, GameState game) {
    this.config = config;
    this.game = game;
  }

  /**
   * Draws the ball object.
   *
   * @param g the graphics object of paintComponent method
   */
  private void drawBall(Graphics g) {
    g.setColor(Color.BLACK);
    g.fillOval(
        game.getBall().getLocation().getX(),
        game.getBall().getLocation().getY(),
        game.getBall().getSize(),
        game.getBall().getSize()
    );
  }

  /**
   * Draws all players.
   *
   * @param g the graphics object of paintComponent method
   */
  private void drawPlayers(Graphics g) {
    game.getPlayers().forEach(
        pl -> g.fillRect(
            pl.getLocation().getX(),
            pl.getLocation().getY(),
            pl.getWidth(),
            pl.getHeight()
        )
    );
  }

  /**
   * Draws all texts on the SwingCanvas.
   *
   * @param g the graphics object of paintComponent method
   */
  private void drawTexts(Graphics g) {
    //Draw scores
    g.drawString("Player 1: " + game.getPlayers().get(0).getScore(), 25, 10);
    g.drawString("Player 2: " + game.getPlayers().get(1).getScore(), config.getWidth() - 100, 10);
    if (!this.game.isPlaying()) {
      g.drawString("Game Over", this.config.getWidth() / 2 - 20, this.config.getHeight() / 2 - 20);
    }
  }

  /**
   * Main drawing method.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawRect(
        game.getArea().getLocation().getX(),
        game.getArea().getLocation().getY(),
        game.getArea().getWidth(),
        game.getArea().getHeight()
    );
    drawBall(g);
    drawPlayers(g);
    drawTexts(g);
  }

  @Override
  public void draw() {
    repaint();
  }
}
