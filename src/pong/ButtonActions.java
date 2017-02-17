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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author d.peters
 */
public class ButtonActions {

    private final GameState game;

    /**
     *
     * @param game
     */
    public ButtonActions(GameState game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    public ItemListener pauseListener() {

        ItemListener listener = (ItemEvent e) -> {

            this.game.pauseToggle();

        };

        return listener;
    }

    /**
     *
     * @return
     */
    public ActionListener restartListener() {

        ActionListener listener = (ActionEvent e) -> {
            this.game.restart();
        };

        return listener;
    }

}
