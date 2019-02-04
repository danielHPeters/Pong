package ch.peters.daniel.pong.ui.swing;

import ch.peters.daniel.pong.config.Settings;
import ch.peters.daniel.pong.game.GameState;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 * Swing canvas implementation.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingCanvas extends JPanel implements Canvas {
  private Settings config;
  private final GameState game;

  /**
   * Default constructor.
   *
   * @param config Default settings
   * @param game   Pong state
   */
  SwingCanvas(Settings config, GameState game) {
    this.config = config;
    this.game = game;
  }

  /**
   * Draws the ball object.
   *
   * @param g2 The graphics object of paintComponent method
   */
  private void drawBall(Graphics2D g2) {
    g2.setColor(Color.BLACK);
    g2.fillOval(
      game.getBall().getLocation().getX(),
      game.getBall().getLocation().getY(),
      game.getBall().getSize(),
      game.getBall().getSize()
    );
  }

  /**
   * Draws all players.
   *
   * @param g2 The graphics object of paintComponent method
   */
  private void drawPlayers(Graphics2D g2) {
    game.getPlayers().forEach(
      pl -> g2.fillRect(
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
   * @param g2 The graphics object of paintComponent method
   */
  private void drawTexts(Graphics2D g2) {
    //Draw scores
    g2.drawString("Player 1: " + game.getPlayers().get(0).getScore(), 25, 10);
    g2.drawString("Player 2: " + game.getPlayers().get(1).getScore(), config.getWidth() - 100, 10);

    if (!this.game.isPlaying()) {
      g2.drawString("Game Over", this.config.getWidth() / 2 - 20, this.config.getHeight() / 2 - 20);
    }
  }

  /**
   * Main drawing method.
   */
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    var g2 = (Graphics2D) g;

    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
    g2.drawRect(
      game.getArea().getLocation().getX(),
      game.getArea().getLocation().getY(),
      game.getArea().getWidth(),
      game.getArea().getHeight()
    );
    drawBall(g2);
    drawPlayers(g2);
    drawTexts(g2);
  }

  @Override
  public void draw() {
    repaint();
  }
}
