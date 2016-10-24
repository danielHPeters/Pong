package pong.gameObjcects;

import interfaces.Collideable;
import java.awt.Rectangle;

/**
 * abstract base class for game objects.
 * @author d.peters
 */
abstract class GameObject implements Collideable{
    
    /**
     * Dimensions of the object
     */
    int width, height;

    /**
     * Position markers of the object
     */
    protected int x, y;
    
    /**
     * getter for object width
     * @return current width
     */
    public int getWidth() {
        return width;
    }

    /**
     * setter for object width
     * @param width new width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * getter for object height
     * @return current object height
     */
    public int getHeight() {
        return height;
    }

    /**
     * setter for height of object
     * @param height new height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * getter for x position
     * @return current x position of the object
     */
    public int getX() {
        return x;
    }

    /**
     * setter for x position
     * @param x new x position
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * getter for y position
     * @return the current y position of the object
     */
    public int getY() {
        return y;
    }

    /**
     * setter for y positon
     * @param y new y position
     */
    public void setY(int y) {
        this.y = y;
    }

    

    /**
     * returns bounding rectangle for collision detection
     * @return bounding rectangle of the object
     */
    @Override
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    /**
     * currently unused collision handler
     */
    @Override
    public void collisionHandler() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
