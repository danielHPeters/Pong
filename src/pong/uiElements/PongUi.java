package pong.uiElements;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JToggleButton;
import pong.ButtonActions;
import pong.GameState;
import pong.RunGame;

/**
 *
 * @author Daniel
 */
public class PongUi {

    /**
     * the game window
     */
    private final GameWindow window;

    /**
     * the drawing painter containing the game loop and objects
     */
    private final Painter painter;

    /**
     *
     */
    private final ButtonActions btnActions;

    /**
     *
     */
    private final JToggleButton pauseButton;

    /**
     *
     */
    private final JButton restartButton;

    /**
     *
     */
    private JMenuBar actionBar;

    public PongUi(GameState game, RunGame loop, int width, int height) {

        this.window = new GameWindow(width, height);
        this.painter = new Painter(width, height, game.getArea(), game.getPlayers(), game.getBall());
        this.actionBar = new JMenuBar();
        this.actionBar.setFocusable(false);

        this.btnActions = new ButtonActions(loop);
        this.pauseButton = new JToggleButton("Pause");
        this.pauseButton.addItemListener(btnActions.pauseListener());

        this.restartButton = new JButton("Restart");
        this.restartButton.addActionListener(btnActions.restartListener());
        this.restartButton.setFocusable(false);

        this.actionBar.add(pauseButton);
        this.actionBar.add(restartButton);

        this.window.add(painter, BorderLayout.CENTER);
        this.window.add(actionBar, BorderLayout.NORTH);
        this.window.pack();
    }

}
