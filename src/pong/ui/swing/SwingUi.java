package pong.ui.swing;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

import pong.configuration.Settings;
import pong.interfaces.ICanvas;
import pong.interfaces.IGameState;
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

  /**
   * Default constructor. Configures all ui components.
   *
   * @param config Default settings
   * @param game   Game state
   */
  public SwingUi(Settings config, IGameState game) {
    window = new SwingWindow(config);
    canvas = new SwingCanvas(config, game);

    var actionBar = new JMenuBar();
    var btnActions = new SwingButtonActions(game);
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
  public ICanvas getCanvas() {
    return canvas;
  }

  @Override
  public IWindow getWindow() {
    return (IWindow) window;
  }
}
