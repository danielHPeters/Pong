package pong.uiElements;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author d.peters
 */
public class GameWindow extends JFrame{
    
    /**
     * 
     * @param dim 
     */
    public GameWindow(int dim){
        initWindow(dim);
    }
    
    /**
     * 
     * @param dim 
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
