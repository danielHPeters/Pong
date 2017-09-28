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

import javax.swing.*;

import pong.configuration.KeyBoardActions;
import pong.configuration.Settings;
import pong.interfaces.IUi;
import pong.ui.SwingUi;

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
    private GameLoop loop;

    /**
     *
     */
    private ScheduledThreadPoolExecutor executor;

    /**
     *
     */
    private GameState game;

    /**
     *
     */
    private GameLogic logic;

    /**
     *
     */
    private IUi ui;

    /**
     * initialize the keybindings of the game
     */
    private KeyBindings keyBindings;

    /**
     *
     */
    private KeyBoardActions actions;

    /**
     * This is the default constructor
     */
    public Main() {



    }

    /**
     * starts the game loop
     */
    public static void start() {

        Main application = new Main();

        // Initialize game objects and logic
        application.config = new Settings(800, 600, 6, 18, 5, 10);
        application.game = new GameState(application.config);
        application.logic = new GameLogic(application.game);

        // Initialize the ui
        application.ui = new SwingUi(application.config, application.game);

        // Initialize the loop / game engine
        application.loop = new GameLoop(application.ui.getCanvas(), application.logic);
        application.executor = new ScheduledThreadPoolExecutor(3);
        application.executor.scheduleAtFixedRate(application.loop, 0L, 100L, TimeUnit.MILLISECONDS);

        // Configure keyboard controls
        application.actions = new KeyBoardActions();
        application.keyBindings = new KeyBindings(application.ui, application.executor, application.game, application.actions);
        application.ui.getWindow().display();
    }

    /**
     * starts the event dispatch thread and starts the game
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::start);
        //BackgroundMusicPlayer player = new BackgroundMusicPlayer();
        //player.playAllClips();

    }
}
