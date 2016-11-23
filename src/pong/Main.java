package pong;

import java.awt.BorderLayout;
import pong.configuration.GameKeyBindings;
import pong.uiElements.GameArea;
import pong.uiElements.GameWindow;
import javax.swing.SwingUtilities;

/**
 * Starter class of the pong game this is a simple remake of the classic pong
 * using an object oriented approach
 *
 * @author d.peters
 * @version 2.6
 * @since 12.10.2016
 */
public class Main {

    private final int dimension = 500;

    /**
     * the game loop
     */
    private final RunGame loop;

    private final Thread executer;

    /**
     * the game window
     */
    private final GameWindow window;

    /**
     * the drawing panel containing the game loop and objects
     */
    private final GameArea panel;

    /**
     * initialize the keybindings of the game
     */
    GameKeyBindings gameKeyBindings;

    /**
     * This is the default constructor
     */
    public Main() {
        this.window = new GameWindow(dimension);
        this.panel = new GameArea(dimension);
        this.gameKeyBindings = new GameKeyBindings(panel, panel.getPlayers());
        this.window.add(panel, BorderLayout.CENTER);
        this.window.pack();
        this.loop = new RunGame(panel);
        this.executer = new Thread(this.loop);
    }

    /**
     * starts the game loop
     */
    public void start() {
        this.window.setVisible(true);
        this.executer.start();
    }

    /**
     * starts the event dispatch thread and starts the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main pong = new Main();
            pong.start();
        });
    }
}
