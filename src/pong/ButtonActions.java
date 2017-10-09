package pong;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

/**
 * Button action listeners.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class ButtonActions {

  private final GameState game;

  public ButtonActions(GameState game) {
    this.game = game;
  }

  public ItemListener pauseListener() {
    return e -> game.pauseToggle();
  }

  public ActionListener restartListener() {
    return e -> game.restart();
  }
}
