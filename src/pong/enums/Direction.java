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
package pong.enums;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author Daniel
 */
public enum Direction {

    UP("UP pressed", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false)),
    UP_REL("UP released", KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, true)),
    DOWN("DOWN pressed", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, false)),
    DOWN_REL("DOWN released", KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0, true)),
    W("W pressed", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, false)),
    W_REL("W released", KeyStroke.getKeyStroke(KeyEvent.VK_W, 0, true)),
    S("S pressed", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, false)),
    S_REL("S released", KeyStroke.getKeyStroke(KeyEvent.VK_S, 0, true));

    Direction(final String text, final KeyStroke keyStroke) {
        this.text = text;
        this.keyStroke = keyStroke;
    }

    private final String text;
    private final KeyStroke keyStroke;

    public String getText() {
        return text;
    }

    public KeyStroke getKeyStroke() {
        return keyStroke;
    }

    @Override
    public String toString() {
        return text;
    }
}
