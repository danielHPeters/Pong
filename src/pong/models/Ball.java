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

import java.awt.*;

/**
 * this class describes a ball object, its movement functions etc.
 *
 * @author d.peters
 */
public class Ball extends MovableObject {

    /**
     * Default constructor setting position, speed, width, height
     *
     * @param xPos  initial x position
     * @param yPos  initial y position
     * @param speed
     */
    public Ball(int xPos, int yPos, int speed) {
        this.up = true;
        this.right = false;
        this.location = new Vector2I(xPos, yPos);
        this.startLocation = new Vector2I(xPos, yPos);
        this.velocity = new Vector2I(2, 1);
        this.acceleration = new Vector2I(1, 1);
        this.maxSpeed = 5;
        this.x = xPos;
        this.y = yPos;
        this.initialX = xPos;
        this.initialY = yPos;
        this.speed = speed;
        this.width = 8;
        this.height = 8;
    }

    /**
     * getter for the site of ball
     *
     * @return current size
     */
    public int getSize() {
        return width;
    }

    /**
     * setter for the site of ball (width and height)
     *
     * @param size new size
     */
    public void setSize(int size) {
        this.width = size;
        this.height = size;
    }

    /**
     * move the ball
     */
    @Override
    public void move() {

        this.location.add(this.velocity);
    }

    /**
     * checks for collision with other objects
     *
     * @param collObj collideable Object
     * @return boolean which tells if there was a collision with an object
     */
    @Override
    public boolean collision(Collideable collObj) {
        boolean coll = false;
        if (collObj.getBounds().intersects(this.getBounds())) {
            coll = true;
        }
        return coll;
    }

    /**
     *
     */
    @Override
    public void collisionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(location.getX(), location.getY(), width, height);
    }
}
