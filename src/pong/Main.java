package pong;

import java.awt.BorderLayout;
import java.util.ArrayList;
import pong.configuration.KeyBindings;
import pong.uiElements.Painter;
import pong.uiElements.GameWindow;
import javax.swing.SwingUtilities;
import pong.configuration.Actions;
import pong.gameObjcects.Ball;
import pong.gameObjcects.Player;

/**
 * Starter class of the pong game this is a simple remake of the classic pong
 * using an object oriented approach
 *
 * @author d.peters
 * @version 2.6
 * @since 12.10.2016
 */
public class Main {

    private final int dimension;

    /**
     * the game loop
     */
    private final RunGame loop;

    private final Thread executer;

    private final GameLogic logic;

    /**
     * the game window
     */
    private final GameWindow window;

    /**
     * the drawing painter containing the game loop and objects
     */
    private final Painter painter;

    /**
     * initialize the keybindings of the game
     */
    private final KeyBindings keyBindings;

    private final Actions actions;

    private final Ball ball;

    private final Player pl1, pl2;

    public ArrayList<Player> players;

    /**
     * This is the default constructor
     */
    public Main() {
        this.dimension = 500;
        this.pl1 = new Player(2 * 5, dimension / 2);
        this.pl2 = new Player(dimension - 4 * 5, dimension / 2);
        this.players = new ArrayList<>();
        this.players.add(pl1);
        this.players.add(pl2);
        this.ball = new Ball(dimension / 2, dimension / 2);
        this.window = new GameWindow(dimension);
        this.painter = new Painter(dimension, players, ball);
        this.actions = new Actions();
        this.keyBindings = new KeyBindings(painter, players, actions);
        this.window.add(painter, BorderLayout.CENTER);
        this.window.pack();
        this.logic = new GameLogic(players, ball, painter);
        this.loop = new RunGame(painter, logic);
        this.executer = new Thread(this.loop);
    }

    /**
     * starts the game loop
     */
    public void start() {
        this.window.setVisible(true);
        this.executer.start();
    }

    /**
     * starts the event dispatch thread and starts the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main pong = new Main();
            pong.start();
        });
    }
}
