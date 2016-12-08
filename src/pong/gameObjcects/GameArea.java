/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong.gameObjcects;

import interfaces.Collideable;

/**
 *
 * @author d.peters
 */
public class GameArea extends GameObject{
    
    public GameArea(int width, int height){
        this.x = 0;
        this.y = 0;
        this.width = width;
        this.height = height;
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
