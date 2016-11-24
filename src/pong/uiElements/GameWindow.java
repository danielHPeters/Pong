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

    /**
     * default constructor
     *
     * @param dim initial dimension of the window
     */
    public GameWindow(int dim) {
        initWindow(dim);
    }

    /**
     * initializes the game window
     *
     * @param dim initial dimension of the window
     */
    private void initWindow(int dim) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(312, 184);
        this.setMinimumSize(new Dimension(dim, dim));
        this.setTitle("Pong");
        this.setLayout(new BorderLayout());
    }
}
