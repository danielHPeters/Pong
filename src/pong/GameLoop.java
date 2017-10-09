package pong;

import pong.interfaces.ICanvas;

/**
 * This class contains the canvas loop, which controls canvas speed, frame rate etc.
 *
 * @author d.peters
 */
public class GameLoop implements Runnable {
  private final int fps;
  private final ICanvas canvas;
  private final GameLogic logic;

  /**
   * Default constructor which fetches the SwingCanvas object and sets the
   * canvas to playing mode.
   *
   * @param canvas reference to canvas
   * @param logic  reference to game logic.
   */
  public GameLoop(ICanvas canvas, GameLogic logic) {
    this.fps = 60;
    this.canvas = canvas;
    this.logic = logic;
  }

  @Override
  public void run() {
    while (this.logic.getState().isPlaying()) {
      long time = System.nanoTime();

      if (!logic.getState().isPaused()) {
        // Move canvas objects repaint
        this.logic.update();
        this.canvas.draw();
      }

      time = (time - System.nanoTime() + (1000000000l / this.fps)) / 1000000l;
      if (time > 0) {
        try {
          Thread.sleep(time);
        } catch (InterruptedException ex) {
          this.logic.getState().setPlaying(false);
        }
      }
    }
  }
}
