package ch.peters.daniel.pong.action;

import ch.peters.daniel.pong.game.GameState;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Button action listeners.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 1.0
 */
public class SwingButtonListeners {
  private final GameState game;

  public SwingButtonListeners(GameState game) {
    this.game = game;
  }

  public ItemListener pauseListener() {
    return event -> game.pauseToggle();
  }

  public ActionListener restartListener() {
    return event -> game.restart();
  }
}
