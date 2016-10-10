/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author d.peters
 */
public class Flipper extends Rectangle {
    public Flipper(int posX, int posY, int width, int height) {
        this.x = posX;
        this.y = posY;
        this.width = width;
        this.height = height;
    }
    
    //private final int step = 5;
    public void moveUp(int step) {
        if (this.y <= (super.getHeight() - 25)) {
            this.y += step;
        }
    }
    
    public void moveDown(int step){
        if (this.y >= 0) {
            this.y -= step;
        }
    }
}
