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
 * @version 2.5
 * @since 12.10.2016
 */
public class Main {

    private final int dimension = 500;
    
    /**
     * the game loop
     */
    private RunGame loop;

    /**
     * the game window
     */
    private final GameWindow window = new GameWindow(dimension);

    /**
     * the drawing panel containing the game loop and objects
     */
    private final GameArea panel = new GameArea(dimension);

    /**
     * initialize the keybindings of the game
     */
    GameKeyBindings gameKeyBindings = new GameKeyBindings(panel, panel.getPlayers());

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
    }
    
    public void start(){
        loop = new RunGame(panel);
        loop.runLoop();
    }

    /**
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main pong = new Main();
            pong.initialize();
            pong.start();
        });
    }
}
