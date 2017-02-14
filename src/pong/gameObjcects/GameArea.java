package pong.gameObjcects;

import pong.interfaces.Collideable;

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

    /**
     * 
     * @param collObj
     * @return 
     */
    @Override
    public boolean collision(Collideable collObj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     */
    @Override
    public void collisionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
