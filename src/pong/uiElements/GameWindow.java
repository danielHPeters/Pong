package pong.uiElements;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;

/**
 *
 * @author d.peters
 */
public class GameWindow extends JFrame{
    
    public GameWindow(){
        initWindow();
    }
    
    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(new Rectangle(312, 184, 250, 250)); // Position on the desktop
        this.setMinimumSize(new Dimension(250, 250));
        this.setMaximumSize(new Dimension(250, 250));
        this.setTitle("Pong");
    }
}
