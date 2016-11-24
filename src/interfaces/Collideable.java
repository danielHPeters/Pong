package interfaces;

import java.awt.Rectangle;

/**
 * interface for objects which can collide with other objects
 *
 * @author d.peters
 */
public interface Collideable {

    public Rectangle getBounds();

    public boolean collision(Collideable collObj);

    public void collisionHandler();
}
