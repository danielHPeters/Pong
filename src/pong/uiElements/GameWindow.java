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
    
    private int dimension;

    /**
     * default constructor
     *
     * @param dimension initial dimension of the window
     */
    public GameWindow(int dimension) {
        this.dimension = dimension;
        initWindow();
    }

    /**
     * initializes the game window
     *
     * @param dim initial dimension of the window
     */
    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocation(312, 184);
        this.setMinimumSize(new Dimension(this.dimension, this.dimension));
        this.setTitle("Pong");
        this.setLayout(new BorderLayout());
    }
    
    /**
     * 
     * @param dimension
     */
    public void setDimension(int dimension){
        this.dimension = dimension;
    }
}
