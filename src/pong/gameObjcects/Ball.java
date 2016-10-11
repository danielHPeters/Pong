/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.gameObjcects;

/**
 *
 * @author d.peters
 */
public class Ball extends GameShape {

    private int size = 8;
    boolean moveRight = true, moveUp = true;

    public Ball(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
        this.speed = 5;
        this.size = 8;
        this.speed = 5;
    }

    /**
     * 
     * @return 
     */
    public int getSize() {
        return size;
    }

    /**
     * 
     * @param size 
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isMoveRight() {
        return moveRight;
    }

    /**
     * 
     * @param moveRight 
     */
    public void moveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    /**
     * 
     * @return 
     */
    public boolean isMoveUp() {
        return moveUp;
    }

    /**
     * 
     * @param moveUp 
     */
    public void moveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }
    
    /**
     * 
     */
    public void moveUp() {
        int move = getY() + speed;
        setY(move);
    }

    /**
     * 
     */
    public void moveDown() {
        int move = getY() - speed;
        setY(move);
    }

    /**
     * 
     */
    public void moveLeft() {
        int move = getX() - speed;
        setX(move);
    }

    /**
     * 
     */
    public void moveRight() {
        int move = getX() + speed;
        setX(move);
    }

    /**
     * 
     * @param panelWidth 
     */
    public void moveHor(int panelWidth) {
        if (this.moveRight) {
            moveRight();
            if (this.getX() >= (panelWidth - this.getSize())) {
                this.moveRight = false;
            }
        } else {
            moveLeft();
            if (this.getX() <= 0) {
                this.moveRight = true;
            }
        }
    }

    /**
     * 
     * @param panelHeight 
     */
    public void moveVert(int panelHeight) {
        if (this.moveUp) {
            moveUp();
            if (this.getY() >= (panelHeight - this.getSize())) {
                this.moveUp = false;
            }
        } else {
            moveDown();
            if (this.getY() <= 0) {
                this.moveUp = true;
            }
        }
    }

}
