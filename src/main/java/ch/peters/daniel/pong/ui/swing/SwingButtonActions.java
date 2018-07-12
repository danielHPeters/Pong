package ch.peters.daniel.pong.ui.swing;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import ch.peters.daniel.pong.game.GameState;

/**
 * Button action listeners.
 *
 * @author Daniel Peters
 * @version 1.0
 */
class SwingButtonActions {
  private final GameState game;

  SwingButtonActions(GameState game) {
    this.game = game;
  }

  ItemListener pauseListener() {
    return event -> game.pauseToggle();
  }

  ActionListener restartListener() {
    return event -> game.restart();
  }
}
