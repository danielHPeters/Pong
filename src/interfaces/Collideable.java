package interfaces;

import java.awt.Rectangle;

/**
 * interface for objects which can collide with other objects
 *
 * @author d.peters
 */
public interface Collideable {

    /**
     * 
     * @return 
     */
    public Rectangle getBounds();

    /**
     * 
     * @param collObj
     * @return 
     */
    public boolean collision(Collideable collObj);

    /**
     * 
     */
    public void collisionHandler();
}
