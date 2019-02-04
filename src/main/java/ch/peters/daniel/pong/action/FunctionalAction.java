package ch.peters.daniel.pong.action;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;

/**
 * Functional action. Use this for shorter action code.
 *
 * @author Daniel Peters
 * @version 1.0
 * @see KeyboardActions
 */
public class FunctionalAction extends AbstractAction {
  private ActionListener action;

  public FunctionalAction(ActionListener action) {
    this.action = action;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    action.actionPerformed(e);
  }
}
