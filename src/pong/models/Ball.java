package pong.models;

import pong.interfaces.Collideable;

/**
 * this class describes a ball object, its movement functions etc.
 *
 * @author d.peters
 */
public class Ball extends MovableObject {

    /**
     * Default constructor setting position, speed, width, height
     *
     * @param xPos initial x position
     * @param yPos initial y position
     * @param speed
     */
    public Ball(int xPos, int yPos, int speed) {
        this.up = true;
        this.right = false;
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
     *
     */
    @Override
    public void move() {
        moveHor();
        moveVert();
    }

    /**
     * move in the horizontal direction
     *
     * @param panelWidth width of the game area
     */
    private void moveHor() {
        if (this.right) {
            moveRight();
        } else {
            moveLeft();
        }
    }

    /**
     * Move in the vertical direcction
     *
     * @param panelHeight height of the game area (used for moving down)
     */
    private void moveVert() {
        if (this.up) {
            moveUp();
        } else {
            moveDown();
        }
    }
    
    /**
     * 
     */
    public void changeVertDir(){
        this.up = !this.up;
    }

    /**
     * changes vertical direction to the opposite direction
     */
    public void changeHorDir() {
        this.right = !this.right;
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
}
