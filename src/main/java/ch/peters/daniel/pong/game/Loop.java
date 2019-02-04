package ch.peters.daniel.pong.game;

import ch.peters.daniel.pong.ui.swing.Canvas;

/**
 * This class contains the canvas loop, which controls canvas speed, frame rate etc.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class Loop implements Runnable {
  private final int fps;
  private final Canvas canvas;
  private final Game game;

  /**
   * Default constructor which fetches the SwingCanvas object and sets the
   * canvas to playing mode.
   *
   * @param canvas Reference to canvas
   * @param game   Reference to game game.
   */
  public Loop(Canvas canvas, Game game) {
    this.fps = 60;
    this.canvas = canvas;
    this.game = game;
  }

  @Override
  public void run() {
    while (game.getState().isPlaying()) {
      var time = System.nanoTime();

      if (!game.getState().isPaused()) {
        // Move canvas objects repaint
        game.update();
        canvas.draw();
      }

      time = (time - System.nanoTime() + (1000000000L / fps)) / 1000000L;

      if (time > 0) {
        try {
          Thread.sleep(time);
        } catch (InterruptedException ex) {
          game.getState().setPlaying(false);
        }
      }
    }
  }
}
