package pong.interfaces;

/**
 * interface for movable objects
 *
 * @author d.peters
 */
public interface Moveable {

    /**
     * 
     */
    public void move();

    /**
     * 
     */
    public void moveUp();

    /**
     * 
     */
    public void moveDown();

    /**
     * 
     */
    public void moveLeft();

    /**
     * 
     */
    public void moveRight();
    
    public void resetPosition();
}
