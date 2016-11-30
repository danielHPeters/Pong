package interfaces;

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
     * @param width
     * @param height 
     */
    public void move(int width, int height);

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
}
