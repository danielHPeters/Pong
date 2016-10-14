/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.gameObjcects;

import interfaces.Moveable;

/**
 *
 * @author d.peters
 */
public class MovableObject extends GameObject implements Moveable {

    protected int speed;
    protected boolean UP, DOWN, LEFT, RIGHT;

    /**
     * 
     * @return 
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * Setter for UP
     *
     * @param UP changes UP if the corresponding Key was pressed or released
     */
    public void setUP(boolean UP) {
        this.UP = UP;
    }

    /**
     * Setter for DOWN
     *
     * @param DOWN changes UP if the corresponding Key was pressed or released
     */
    public void setDOWN(boolean DOWN) {
        this.DOWN = DOWN;
    }

    /**
     * 
     * @param LEFT 
     */
    public void setLEFT(boolean LEFT) {
        this.LEFT = LEFT;
    }

    /**
     * 
     * @param RIGHT 
     */
    public void setRIGHT(boolean RIGHT) {
        this.RIGHT = RIGHT;
    }
    

    /**
     * 
     * @param speed 
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    @Override
    public void moveUp() {
        this.y -= speed;
    }

    @Override
    public void moveDown() {
        this.y += speed;
    }

    @Override
    public void moveLeft() {
        this.x -= speed;
    }

    @Override
    public void moveRight() {
        this.x += speed;
    }
}
