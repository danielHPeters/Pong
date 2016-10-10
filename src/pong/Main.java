package pong;

import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;



public class Main extends JFrame {
    private final JFrame window = new JFrame();
    private final GamePanel panel = new GamePanel(); // This is the panel of the game class
    Thread gameLoop = new Thread();

    /**
     * This is the default constructor
     */
    public Main() {
        initialize();
    }

    /**
     * This method initializes this JFrame
     *
     * @return void
     */
    private void initialize() {
        GameKeyBindings gameKeyBindings = new GameKeyBindings(
                panel, panel.playerOne, panel.playerTwo
        );
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setBounds(new Rectangle(312, 184, 250, 250)); // Position on the desktop
        window.setMinimumSize(new Dimension(250, 250));
        window.setMaximumSize(new Dimension(250, 250));
        window.setTitle("Pong");
        window.add(panel);
        window.pack();
        window.setVisible(true);
    }
    
    

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main pong = new Main();
        });
    }
}
