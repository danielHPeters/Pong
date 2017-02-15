package pong.uiElements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import pong.configuration.Settings;

/**
 * the window of the game which contains the GameArea
 *
 * @author d.peters
 */
public class GameWindow extends JFrame {
    
    private final Settings config;

    /**
     * 
     * @param config 
     */
    public GameWindow(Settings config) {
        this.config = config;
        initWindow();
    }

    /**
     * initializes the game window
     *
     * @param dim initial dimension of the window
     */
    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(312, 184);
        this.setMinimumSize(new Dimension(this.config.getWidth() + 20, this.config.getHeight() + 20));
        this.setTitle("Pong");
        this.setLayout(new BorderLayout());
    }
}
