/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

/**
 *
 * @author d.peters
 */
public class Ball {
    private int xPos;
    private int yPos;
    private int size = 8;
    private int speed = 5;
    
    public Ball (int xPos, int yPos){
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void moveUp(){
        int move = getyPos() + speed;
        setyPos(move);
    }
    
    public void moveDown(){
        int move = getyPos() - speed;
        setyPos(move);
    }
    
    public void moveLeft(){
        int move = getxPos() - speed;
        setxPos(move);
    }
    
    public void moveRight(){
        int move = getxPos() + speed;
        setxPos(move);
    }
    
    
}
