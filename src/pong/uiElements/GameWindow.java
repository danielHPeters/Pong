package pong.uiElements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 * the window of the game which contains the GameArea
 *
 * @author d.peters
 */
public class GameWindow extends JFrame {
    
    private final int width;
    
    private final int height;

    /**
     * default constructor
     *
     * @param width
     * @param height
     */
    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
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
        this.setMinimumSize(new Dimension(this.width + 20, this.height + 20));
        this.setTitle("Pong");
        this.setLayout(new BorderLayout());
    }
}
