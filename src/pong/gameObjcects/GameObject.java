package pong.gameObjcects;

import interfaces.Collideable;
import java.awt.Rectangle;

/**
 *
 * @author d.peters
 */
abstract class GameObject implements Collideable{
    
    /**
     * Dimensions of the object
     */
    int width, height;

    protected int x, y;

    /**
     * 
     * @return 
     */
    public int getX() {
        return x;
    }

    /**
     * 
     * @param x 
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * 
     * @return 
     */
    public int getY() {
        return y;
    }

    /**
     * 
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }

    

    /**
     * 
     * @return 
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * 
     */
    @Override
    public void collisionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
