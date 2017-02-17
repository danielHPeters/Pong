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

/**
 * Definition of the player object
 *
 * @author d.peters
 */
public class Player extends MovableObject {

    /**
     * counter for player score
     */
    private int score = 0;

    /**
     * default constructor.
     * initializes the players x and y position as well ad the  width and height
     * @param posX X position on gamearea
     * @param posY Y position on gamearea
     */
    public Player(int posX, int posY, int speed) {
        this.up = false;
        this.down = false;
        this.x = posX;
        this.y = posY;
        this.initialX = posX;
        this.initialY = posY;
        this.speed = speed;
        this.width = 5;
        this.height = 40;
    }

    /**
     * getter for the player score
     *
     * @return the current score
     */
    public int getScore() {
        return score;
    }

    /**
     * Setter for the player score
     *
     * @param score new score
     */
    public void setScore(int score) {
        this.score = score;
    }

    /**
     * add +1 to score counter of the player
     */
    public void incrementScore() {
        this.score += 1;
    }
    
    /**
     * 
     */
    public void resetScore(){
        this.score = 0;
    }

    /**
     * Check for keys pressed and moveVert according to key (Workaround for
     * input lag)d
     * @param areaHeight
     */
    public void moveVert(int areaHeight) {
        if (this.up && this.y + - 10 >= 0) {
            this.moveUp();
        }
        if (this.down && this.y < areaHeight - this.height) {
            this.moveDown();
        }
    }

    /**
     * check if the player has won the game
     *
     * @param victCond the amount of scores required to win
     * @return boolean which tells the game whether the player has won
     */
    public boolean hasWon(int victCond) {
        boolean isWinner = false;
        if (this.score == victCond) {
            isWinner = true;
        }
        return isWinner;
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean collision(Collideable collObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void collisionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
