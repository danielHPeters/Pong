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

import pong.interfaces.ICanvas;

/**
 * this class contains the canvas loop, which controls canvas speed, frame rate
 * etc.
 *
 * @author d.peters
 */
public class GameLoop implements Runnable {

    /**
     *
     */
    private final int fps;

    /**
     *
     */
    private final ICanvas canvas;

    /**
     *
     */
    private final GameLogic logic;

    /**
     * default constructor which fetches the SwingCanvas objecct and sets the
     * canvas to playing mode
     *
     * @param canvas
     * @param logic
     */
    public GameLoop(ICanvas canvas, GameLogic logic) {
        this.fps = 60;
        this.canvas = canvas;
        this.logic = logic;
    }

    /**
     *
     */
    @Override
    public void run() {

        while (this.logic.getState().isPlaying()) {

            long time = System.currentTimeMillis();

            if (!logic.getState().isPaused()) {
                // Move canvas objects repaint
                this.logic.update();
                this.canvas.draw();
            }

            //  delay for each frame  -   time it took for one frame
            time = (1000l / this.fps) - (System.currentTimeMillis() - time);
            if (time > 0) {
                try {
                    Thread.sleep(time);
                } catch (InterruptedException ex) {
                    this.logic.getState().setPlaying(false);
                }
            }
        }
    }
}
