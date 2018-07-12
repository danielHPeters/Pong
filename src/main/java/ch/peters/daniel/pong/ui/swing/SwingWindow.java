package ch.peters.daniel.pong.ui.swing;

import ch.peters.daniel.pong.configuration.Settings;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 * The main window of the game.
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class SwingWindow extends JFrame implements Window {
  private final Settings config;

  /**
   * Default constructor. Initializes the main window.
   *
   * @param config Default settings
   */
  SwingWindow(Settings config) {
    this.config = config;
    initWindow();
  }

  /**
   * Initializes the game window.
   */
  private void initWindow() {
    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    setLocation(312, 184);
    setMinimumSize(new Dimension(config.getWidth() + 20, config.getHeight() + 20));
    setTitle("Pong");
    setLayout(new BorderLayout());
    setLandF();
  }

  /**
   * Set look and feel of the ui to nimbus.
   */
  private void setLandF() {
    try {
      for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public void display() {
    setVisible(true);
  }

  @Override
  public void close() {
    dispose();
  }
}
