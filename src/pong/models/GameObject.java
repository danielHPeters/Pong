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
package pong.models;

import pong.interfaces.Collideable;
import pong.interfaces.IVector2I;

import java.awt.Rectangle;

/**
 * abstract base class for game objects.
 *
 * @author d.peters
 */
abstract class GameObject implements Collideable {

    /**
     * Dimensions of the object
     */
    protected int width, height;

    /**
     * Position markers of the object
     */
    protected int x, y;

    /**
     * getter for object width
     *
     * @return current width
     */
    public int getWidth() {
        return width;
    }

    /**
     * setter for object width
     *
     * @param width new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getter for object height
     *
     * @return current object height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setter for height of object
     *
     * @param height new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getter for x position
     *
     * @return current x position of the object
     */
    public int getX() {
        return x;
    }

    /**
     * setter for x position
     *
     * @param x new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter for y position
     *
     * @return the current y position of the object
     */
    public int getY() {
        return y;
    }

    /**
     * setter for y positon
     *
     * @param y new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * returns bounding rectangle for collision detection
     *
     * @return bounding rectangle of the object
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }
}
