package pong.ui.swing;

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;

import pong.interfaces.IGameState;

/**
 * Button action listeners.
 *
 * @author Daniel Peters
 * @version 1.0
 */
class SwingButtonActions {
  private final IGameState game;

  SwingButtonActions(IGameState game) {
    this.game = game;
  }

  ItemListener pauseListener() {
    return event -> game.pauseToggle();
  }

  ActionListener restartListener() {
    return event -> game.restart();
  }
}
