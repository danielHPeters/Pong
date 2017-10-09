package pong.ui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import pong.ButtonActions;
import pong.GameState;
import pong.configuration.Settings;
import pong.interfaces.ICanvas;
import pong.interfaces.IUi;
import pong.interfaces.IWindow;

/**
 * Swing implementation of IUI interface.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingUi implements IUi {
  private JFrame window;
  private final ICanvas canvas;
  private final ButtonActions btnActions;
  private final JToggleButton pauseButton;
  private final JButton restartButton;
  private JMenuBar actionBar;

  /**
   * Default constructor. Configures all ui components.
   *
   * @param config default settings
   * @param game   game state
   */
  public SwingUi(Settings config, GameState game) {
    window = new SwingWindow(config);
    canvas = new SwingCanvas(config, game);
    actionBar = new JMenuBar();
    actionBar.setFocusable(false);
    btnActions = new ButtonActions(game);
    pauseButton = new JToggleButton("Pause");
    pauseButton.addItemListener(btnActions.pauseListener());
    restartButton = new JButton("Restart");
    restartButton.addActionListener(btnActions.restartListener());
    restartButton.setFocusable(false);
    actionBar.add(pauseButton);
    actionBar.add(restartButton);
    window.add((JPanel) canvas, BorderLayout.CENTER);
    window.add(actionBar, BorderLayout.NORTH);
    window.pack();
  }

  @Override
  public ICanvas getCanvas() {
    return canvas;
  }

  @Override
  public IWindow getWindow() {
    return (IWindow) window;
  }
}
