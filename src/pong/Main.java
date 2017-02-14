package pong;

import pong.audio.BackgroundMusicPlayer;
import java.awt.BorderLayout;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import pong.configuration.KeyBindings;
import pong.uiElements.Painter;
import pong.uiElements.GameWindow;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pong.configuration.KeyBoardActions;

/**
 * Starter class of the pong game this is a simple remake of the classic pong
 * using an object oriented approach
 *
 * @author d.peters
 * @version 2.6
 * @since 12.10.2016
 */
public class Main {

    /**
     *
     */
    private final int width;

    /**
     *
     */
    private final int height;

    /**
     * the game loop
     */
    private final RunGame loop;

    /**
     *
     */
    private final ScheduledThreadPoolExecutor executor;

    /**
     *
     */
    private final GameLogic logic;

    /**
     * the game window
     */
    private final GameWindow window;

    /**
     * the drawing painter containing the game loop and objects
     */
    private final Painter painter;

    /**
     *
     */
    private final ButtonActions btnActions;

    /**
     *
     */
    private final JToggleButton pauseButton;

    /**
     *
     */
    private final JButton restartButton;

    /**
     *
     */
    private JMenuBar actionBar;
    
    /**
     * 
     */
    private GameState game;

    /**
     * initialize the keybindings of the game
     */
    private final KeyBindings keyBindings;

    /**
     *
     */
    private final KeyBoardActions actions;

    /**
     * This is the default constructor
     */
    public Main() {
        
        this.width = 800;
        this.height = 600;
        this.game = new GameState(width, height);
        this.window = new GameWindow(width, height);
        this.painter = new Painter(width, height, game.getArea(), game.getPlayers(), game.getBall());
        this.actions = new KeyBoardActions();
        this.logic = new GameLogic(game.getArea(), game.getPlayers(), game.getBall(), painter);
        this.loop = new RunGame(painter, logic);
        this.executor = new ScheduledThreadPoolExecutor(3);
        this.executor.scheduleAtFixedRate(loop, 0L, 100L, TimeUnit.MILLISECONDS);
        this.keyBindings = new KeyBindings(window, painter, executor, loop, game.getPlayers(), actions);

        this.actionBar = new JMenuBar();
        this.actionBar.setFocusable(false);

        this.btnActions = new ButtonActions(loop);
        this.pauseButton = new JToggleButton("Pause");
        this.pauseButton.addItemListener(btnActions.pauseListener());

        this.restartButton = new JButton("Restart");
        this.restartButton.addActionListener(btnActions.restartListener());
        this.restartButton.setFocusable(false);

        this.actionBar.add(pauseButton);
        this.actionBar.add(restartButton);

        this.window.add(painter, BorderLayout.CENTER);
        this.window.add(actionBar, BorderLayout.NORTH);
        this.window.pack();
        
    }

    /**
     * starts the game loop
     */
    public void start() {
        this.window.setVisible(true);
    }

    /**
     * starts the event dispatch thread and starts the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            try {

                UIManager.setLookAndFeel(
                        "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e) {
            }

            Main pong = new Main();
            SwingUtilities.updateComponentTreeUI(pong.window);
            pong.start();
        });
        //BackgroundMusicPlayer player = new BackgroundMusicPlayer();
        //player.playAllClips();

    }
}
