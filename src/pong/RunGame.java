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

import javax.swing.JPanel;

/**
 * this class contains the painter loop, which controls painter speed, framerate
 * etc.
 *
 * @author d.peters
 */
public class RunGame implements Runnable {

    /**
     *
     */
    private final JPanel painter;

    /**
     *
     */
    private final GameLogic logic;

    /**
     * default constructor which fetches the Painter objecct and sets the
     * painter to playing mode
     *
     * @param painter
     * @param logic
     */
    public RunGame(JPanel painter, GameLogic logic) {
        this.painter = painter;
        this.logic = logic;
    }

    /**
     *
     */
    @Override
    public void run() {

        while (this.logic.getGame().isPlaying()) {

            if (!logic.getGame().isPaused()) {
                // Move painter objects repaint
                this.logic.update();
                this.painter.repaint();
            }

            try {
                Thread.sleep(this.logic.getGame().getConfig().getGameSpeed());
            } catch (InterruptedException ex) {
                this.logic.getGame().setPlaying(false);
            }

        }
    }
}
