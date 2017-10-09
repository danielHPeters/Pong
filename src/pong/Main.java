package pong;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.SwingUtilities;

import pong.configuration.KeyBindings;
import pong.configuration.KeyBoardActions;
import pong.configuration.Settings;
import pong.interfaces.IUi;
import pong.ui.SwingUi;

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
  private GameLoop loop;
  private ScheduledThreadPoolExecutor executor;
  private GameState game;
  private GameLogic logic;
  private IUi ui;
  private KeyBindings keyBindings;
  private KeyBoardActions actions;

  /**
   * starts the game loop.
   */
  private static void start() {
    Main application = new Main();

    // Initialize game objects and logic
    application.config = new Settings(800, 600, 6, 18, 5);
    application.game = new GameState(application.config);
    application.logic = new GameLogic(application.game);

    // Initialize the ui
    application.ui = new SwingUi(application.config, application.game);

    // Initialize the loop / game engine
    application.loop = new GameLoop(application.ui.getCanvas(), application.logic);
    application.executor = new ScheduledThreadPoolExecutor(3);
    application.executor.scheduleAtFixedRate(application.loop, 0L, 100L, TimeUnit.MILLISECONDS);

    // Configure keyboard controls
    application.actions = new KeyBoardActions();
    application.keyBindings = new KeyBindings(
        application.ui, application.executor, application.game, application.actions);
    application.ui.getWindow().display();
  }

  /**
   * Starts the event dispatch thread and starts the game.
   *
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    SwingUtilities.invokeLater(Main::start);
    // BackgroundMusicPlayer player = new BackgroundMusicPlayer();
    // player.playAllClips();
  }
}
