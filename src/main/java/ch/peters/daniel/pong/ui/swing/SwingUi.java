package ch.peters.daniel.pong.ui.swing;

import ch.peters.daniel.pong.action.SwingButtonListeners;
import ch.peters.daniel.pong.configuration.Settings;
import ch.peters.daniel.pong.game.GameState;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Swing implementation of UI interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingUi implements Ui {
  private JFrame window;
  private final Canvas canvas;

  /**
   * Default constructor. Configures all ui components.
   *
   * @param config Default settings
   * @param game   Pong state
   */
  public SwingUi(Settings config, GameState game) {
    window = new SwingWindow(config);
    canvas = new SwingCanvas(config, game);

    var actionBar = new JMenuBar();
    var btnActions = new SwingButtonListeners(game);
    var pauseButton = new JToggleButton("Pause");
    var restartButton = new JButton("Restart");

    actionBar.setFocusable(false);
    pauseButton.addItemListener(btnActions.pauseListener());
    restartButton.addActionListener(btnActions.restartListener());
    restartButton.setFocusable(false);
    actionBar.add(pauseButton);
    actionBar.add(restartButton);
    window.add((JPanel) canvas, BorderLayout.CENTER);
    window.add(actionBar, BorderLayout.NORTH);
    window.pack();
  }

  @Override
  public Canvas getCanvas() {
    return canvas;
  }

  @Override
  public Window getWindow() {
    return (Window) window;
  }
}
