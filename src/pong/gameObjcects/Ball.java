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
public class Ball {

    private int x;
    private int y;
    private int size = 8;
    private int speed = 5;
    boolean moveRight = true;
    boolean moveUp = true;

    public Ball(int xPos, int yPos) {
        this.x = xPos;
        this.y = yPos;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
    
    public boolean isMoveRight() {
        return moveRight;
    }

    public void moveRight(boolean moveRight) {
        this.moveRight = moveRight;
    }

    public boolean isMoveUp() {
        return moveUp;
    }

    public void moveUp(boolean moveUp) {
        this.moveUp = moveUp;
    }
    
    

    public void moveUp() {
        int move = getY() + speed;
        setY(move);
    }

    public void moveDown() {
        int move = getY() - speed;
        setY(move);
    }

    public void moveLeft() {
        int move = getX() - speed;
        setX(move);
    }

    public void moveRight() {
        int move = getX() + speed;
        setX(move);
    }

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
