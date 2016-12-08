/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enums;

import java.awt.event.KeyEvent;
import javax.swing.KeyStroke;

/**
 *
 * @author d.peters
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
