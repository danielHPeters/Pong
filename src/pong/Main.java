package pong;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

import pong.configuration.Settings;
import pong.game.Game;
import pong.game.GameState;
import pong.game.Loop;
import pong.interfaces.IGame;
import pong.interfaces.IGameState;
import pong.interfaces.IKeyboardActions;
import pong.interfaces.IUi;
import pong.interfaces.Keybindings;
import pong.ui.swing.SwingKeyBindings;
import pong.ui.swing.SwingKeyboardActions;
import pong.ui.swing.SwingUi;

/**
 * Starter class of the pong game. This is a simple remake of the classic pong
 * using an object oriented approach.
 *
 * @author Daniel Peters
 * @version 2.6
 * @since 12.10.2016
 */
public class Main {
  private Settings config;
  private Loop loop;
  private ScheduledThreadPoolExecutor executor;
  private IGameState game;
  private IGame logic;
  private IUi ui;
  private Keybindings keyBindings;
  private IKeyboardActions actions;

  /**
   * Starts the game loop.
   */
  private static void start() {
    var application = new Main();

    // Initialize game objects and logic
    application.config = new Settings(800, 600, 6, 18, 5);
    application.game = new GameState(application.config);
    application.logic = new Game(application.game);

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
    SwingUtilities.invokeLater(Main::start);
  }
}
