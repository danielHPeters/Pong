package ch.peters.daniel.pong;

import ch.peters.daniel.pong.action.KeyboardActions;
import ch.peters.daniel.pong.action.SwingKeyboardActions;
import ch.peters.daniel.pong.config.Settings;
import ch.peters.daniel.pong.control.Keybindings;
import ch.peters.daniel.pong.control.SwingKeyBindings;
import ch.peters.daniel.pong.game.Game;
import ch.peters.daniel.pong.game.GameState;
import ch.peters.daniel.pong.game.Loop;
import ch.peters.daniel.pong.game.Pong;
import ch.peters.daniel.pong.game.PongState;
import ch.peters.daniel.pong.ui.swing.SwingUi;
import ch.peters.daniel.pong.ui.swing.Ui;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

/**
 * Starter class of the pong game. This is a simple remake of the classic pong
 * using an object oriented approach.
 *
 * @author Daniel Peters <daniel.peters.ch@gmail.com>
 * @version 2.6
 * @since 12.10.2016
 */
public class App {
  private Settings config;
  private Loop loop;
  private ScheduledThreadPoolExecutor executor;
  private GameState game;
  private Game logic;
  private Ui ui;
  private Keybindings keyBindings;
  private KeyboardActions actions;

  /**
   * Starts the game loop.
   */
  private static void start() {
    var application = new App();

    // Initialize game objects and logic
    application.config = new Settings(800, 600, 6, 18, 5);
    application.game = new PongState(application.config);
    application.logic = new Pong(application.game);

    // Initialize the ui
    application.ui = new SwingUi(application.config, application.game);

    // Initialize the loop / game engine
    application.loop = new Loop(application.ui.getCanvas(), application.logic);
    application.executor = (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(3);
    application.executor.scheduleAtFixedRate(application.loop, 0L, 100L, TimeUnit.MILLISECONDS);

    // Configure keyboard controls
    application.actions = new SwingKeyboardActions();
    application.keyBindings = new SwingKeyBindings(
        application.ui, application.executor, application.game, application.actions);
    application.ui.getWindow().display();
  }

  /**
   * Starts the event dispatch thread and starts the game.
   *
   * @param args The command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(App::start);
  }
}
