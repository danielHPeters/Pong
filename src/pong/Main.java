/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pong;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import pong.configuration.KeyBindings;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import pong.configuration.KeyBoardActions;
import pong.configuration.Settings;
import pong.ui.PongUi;

/**
 * Starter class of the pong game this is a simple remake of the classic pong
 * using an object oriented approach
 *
 * @author d.peters
 * @version 2.6
 * @since 12.10.2016
 */
public class Main {

    /**
     *
     */
    private Settings config;

    /**
     * the game loop
     */
    private final RunGame loop;

    /**
     *
     */
    private final ScheduledThreadPoolExecutor executor;

    /**
     *
     */
    private GameState game;

    /**
     *
     */
    private final GameLogic logic;

    /**
     *
     */
    private final PongUi ui;

    /**
     * initialize the keybindings of the game
     */
    private final KeyBindings keyBindings;

    /**
     *
     */
    private final KeyBoardActions actions;

    /**
     * This is the default constructor
     */
    public Main() {

        // Initialize game objects and logic
        this.config = new Settings(800, 600, 6, 18, 5, 10);
        this.game = new GameState(config);
        this.logic = new GameLogic(game);

        // Initialize the ui
        this.ui = new PongUi(config, game);

        // Initialize the loop / game engine
        this.loop = new RunGame(ui.getPainter(), logic);
        this.executor = new ScheduledThreadPoolExecutor(3);
        this.executor.scheduleAtFixedRate(loop, 0L, 100L, TimeUnit.MILLISECONDS);

        // Configure keyboard controls
        this.actions = new KeyBoardActions();
        this.keyBindings = new KeyBindings(ui, executor, game, actions);

    }

    /**
     * Set look and feel of the ui to nimbus.
     */
    public void setLandF() {
        try {

            UIManager.setLookAndFeel(
                    "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");

        } catch (ClassNotFoundException | InstantiationException
                | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
        SwingUtilities.updateComponentTreeUI(this.ui.getWindow());
    }

    /**
     * starts the game loop
     */
    public void start() {
        this.ui.getWindow().setVisible(true);
    }

    /**
     * starts the event dispatch thread and starts the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            Main pong = new Main();
            pong.setLandF();
            pong.start();

        });
        //BackgroundMusicPlayer player = new BackgroundMusicPlayer();
        //player.playAllClips();

    }
}
