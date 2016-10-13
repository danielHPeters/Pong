package pong;

import java.awt.BorderLayout;
import pong.configuration.GameKeyBindings;
import pong.uiElements.GamePanel;
import pong.uiElements.GameWindow;
import javax.swing.SwingUtilities;

/**
 * Starter class of the pong game this is a simple remake of the classic pong
 * using an object oriented approach
 *
 * @author d.peters
 * @version 2.5
 * @since 12.10.2016
 */
public class Main {

    private final int dimension = 500;
    
    /**
     * the game window
     */
    private final GameWindow window = new GameWindow(dimension);

    /**
     * the drawing panel containing the game loop and objects
     */
    private final GamePanel panel = new GamePanel(dimension);

    /**
     * initialize the keybindings of the game
     */
    GameKeyBindings gameKeyBindings = new GameKeyBindings(panel, panel.getPlayers());

    /**
     * thread which runs the game loop
     */
    Thread gameLoop;

    /**
     * This is the default constructor It initializes all the components
     */
    public Main() {
    }

    /**
     * initializes the JFrame window
     */
    public void initialize() {
        window.add(panel, BorderLayout.CENTER);
        window.pack();
        window.setVisible(true);
        panel.setPlaying(true);
        gameLoop = new Thread(panel);
        gameLoop.start();
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main pong = new Main();
            pong.initialize();
        });
    }
}
