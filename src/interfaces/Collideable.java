package interfaces;

import java.awt.Rectangle;

/**
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
     */
    public void collisionHandler();
}
