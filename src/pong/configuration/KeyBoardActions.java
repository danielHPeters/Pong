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

import java.awt.event.ActionEvent;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import pong.GameState;
import pong.models.Player;

/**
 *
 * @author d.peters
 */
public class KeyBoardActions {

    /**
     * this method creates the methods for the up actions
     *
     * @param player the player object
     * @param toggleUp boolean which is true for key pressed and for for key
     * released
     * @return the abstract action
     */
    public Action upAction(Player player, boolean toggleUp) {
        Action upAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.setUp(toggleUp);
            }

        };
        return upAction;
    }

    /**
     * this method creates the methods for the down actions
     *
     * @param player the player object
     * @param ToggleDown boolean which is true for key pressed and for for key
     * released
     * @return the abstract action
     */
    public Action downAction(Player player, boolean ToggleDown) {

        Action downAction = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                player.setDown(ToggleDown);
            }

        };

        return downAction;
    }

    /**
     *
     * @param window
     * @param game
     * @param executor
     * @return
     */
    public Action escAction(JFrame window, GameState game,
            ScheduledThreadPoolExecutor executor) {

        Action esc = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.setPlaying(false);
                executor.shutdown();
                window.dispose();
            }

        };

        return esc;
    }

    /**
     *
     * @param game
     * @return
     */
    public Action restartAction(GameState game) {

        Action restart = new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                game.restart();
            }

        };

        return restart;
    }

}
