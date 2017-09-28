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
package pong.configuration;

import com.sun.glass.events.KeyEvent;
import pong.enums.Direction;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.*;

import pong.GameState;
import pong.interfaces.IUi;
import pong.ui.SwingUi;

/**
 * Keyboard configuration of the Game
 *
 * @author Daniel Peters
 * @version 1.0
 */
public class KeyBindings {

    /**
     * Reference to the main UI
     */
    private final IUi ui;

    /**
     * Thread executor which restarts main thread after pause
     */
    private final ScheduledThreadPoolExecutor executor;

    /**
     * Actions executed on specific keyboard events
     */
    private final KeyBoardActions actions;

    /**
     * State of the game and game objects;
     */
    private final GameState game;

    /**
     * default constructor which initializes the keyboard configs
     *
     * @param ui
     * @param executor
     * @param game
     * @param actions
     */
    public KeyBindings(IUi ui, ScheduledThreadPoolExecutor executor,
                       GameState game, KeyBoardActions actions) {
        this.executor = executor;
        this.ui = ui;
        this.actions = actions;
        this.game = game;
        initialize();
    }

    /**
     * initialization method which binds keys to action methods
     */
    private void initialize() {
        // Get the input map of the GamePanel
        InputMap iMap = ((JPanel) this.ui.getCanvas()).getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        ActionMap aMap = ((JPanel) this.ui.getCanvas()).getActionMap();

        for (Direction dir : Direction.values()) {
            iMap.put(dir.getKeyStroke(), dir.getText());
        }

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESC pressed");
        aMap.put("ESC pressed", actions.escAction(this.ui.getWindow(), game, executor));

        iMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_R, 0), "R pressed");
        aMap.put("R pressed", actions.restartAction(game));

        /* W key */
        // put the action functions to the map
        aMap.put("W pressed", this.actions.upAction(this.game.getPlayers().get(0), true));
        // Boolean param true for key released
        aMap.put("W released", this.actions.upAction(this.game.getPlayers().get(0), false));

        /* S key */
        aMap.put("S pressed", this.actions.downAction(this.game.getPlayers().get(0), true));
        aMap.put("S released", this.actions.downAction(this.game.getPlayers().get(0), false));

        /* UP Arrow key */
        aMap.put("UP pressed", this.actions.upAction(this.game.getPlayers().get(1), true));
        aMap.put("UP released", this.actions.upAction(this.game.getPlayers().get(1), false));

        /* DOWN Arrow key */
        aMap.put("DOWN pressed", this.actions.downAction(this.game.getPlayers().get(1), true));
        aMap.put("DOWN released", this.actions.downAction(this.game.getPlayers().get(1), false));
    }

}
