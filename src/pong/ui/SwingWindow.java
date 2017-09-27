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
package pong.ui;

import java.awt.*;
import javax.swing.*;

import pong.configuration.Settings;
import pong.interfaces.IWindow;

/**
 * the window of the game which contains the GameArea
 *
 * @author d.peters
 */
public class SwingWindow extends JFrame implements IWindow {

    /**
     *
     */
    private final Settings config;

    /**
     * @param config
     */
    public SwingWindow(Settings config) {
        this.config = config;
        initWindow();
    }

    /**
     * initializes the game window
     */
    private void initWindow() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(312, 184);
        this.setMinimumSize(new Dimension(this.config.getWidth() + 20, this.config.getHeight() + 20));
        this.setTitle("Pong");
        this.setLayout(new BorderLayout());
        this.setLandF();
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
        SwingUtilities.updateComponentTreeUI(this);
    }

    @Override
    public void display() {
        setVisible(true);
    }

    @Override
    public void close() {
        dispose();
    }
}
