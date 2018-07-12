package ch.peters.daniel.pong.ui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

import ch.peters.daniel.pong.configuration.Settings;

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
      UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException
        | IllegalAccessException | UnsupportedLookAndFeelException e) {
      System.out.println("Failed to set look and feel.");
    }
    SwingUtilities.updateComponentTreeUI(this);
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
