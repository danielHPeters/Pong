/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;

/**
 *
 * @author d.peters
 */
public class Flipper extends Rectangle {
    public boolean UP = false, DOWN = false; 
    private int score = 0;
    private int speed = 10;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public void incrementScore(){
        int oldScore = this.getScore();
        setScore(oldScore += 1);
    }
    
    public Flipper(int posX, int posY, int width, int height) {
        this.x = posX;
        this.y = posY;
        this.width = width;
        this.height = height;
    }
    
    public void move (int panelHeight){
        if (this.UP){
            this.moveUp();
        }
        if (this.DOWN) {
            this.moveDown(panelHeight);
        }
    }

    public void moveUp() {
        if (this.y >= 0) {
            this.y -= speed;
        }
    }

    public void moveDown(int panelHeight) {
        if (this.getY() <= panelHeight) {
            this.y += speed;
        }
    }
}
