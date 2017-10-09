package pong.game;

import pong.interfaces.ICanvas;
import pong.interfaces.IGame;

/**
 * This class contains the canvas loop, which controls canvas speed, frame rate etc.
 *
 * @author d.peters
 */
public class Loop implements Runnable {
  private final int fps;
  private final ICanvas canvas;
  private final IGame game;

  /**
   * Default constructor which fetches the SwingCanvas object and sets the
   * canvas to playing mode.
   *
   * @param canvas reference to canvas
   * @param game   reference to game game.
   */
  public Loop(ICanvas canvas, IGame game) {
    this.fps = 60;
    this.canvas = canvas;
    this.game = game;
  }

  @Override
  public void run() {
    while (game.getState().isPlaying()) {
      long time = System.nanoTime();

      if (!game.getState().isPaused()) {
        // Move canvas objects repaint
        game.update();
        canvas.draw();
      }

      time = (time - System.nanoTime() + (1000000000l / fps)) / 1000000l;
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
