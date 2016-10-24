package pong.gameObjcects;

import interfaces.Moveable;

/**
 * abstract class which defines movable game objects
 * @author d.peters
 */
abstract class MovableObject extends GameObject implements Moveable {

    /**
     * movement speed of the object
     */
    protected int speed;
    
    /**
     * booleans telling the object to move in certain directions
     */
    protected boolean up, down, left, right;

    /**
     * getter for the object speed
     * @return the current object speed
     */
    public int getSpeed() {
        return speed;
    }
    
    /**
     * setter for the object speed
     * @param speed new object speed
     */
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    /**
     * setter for up
     * @param up new status for up
     */
    public void setUp(boolean up) {
        this.up = up;
    }

    /**
     * setter for down
     * @param down new status for down
     */
    public void setDown(boolean down) {
        this.down = down;
    }

    /**
     * setter for left
     * @param left new status for left
     */
    public void setLeft(boolean left) {
        this.left = left;
    }

    /**
     * setter for right
     * @param right new status for right
     */
    public void setRight(boolean right) {
        this.right = right;
    }
    
    /**
     * move object up with its own speed
     */
    @Override
    public void moveUp() {
        this.y -= speed;
    }

    /**
     * move object down with its own speed
     */
    @Override
    public void moveDown() {
        this.y += speed;
    }

    /**
     * move object left with its own speed
     */
    @Override
    public void moveLeft() {
        this.x -= speed;
    }

    /**
     * move object right with its own speed
     */
    @Override
    public void moveRight() {
        this.x += speed;
    }
}
