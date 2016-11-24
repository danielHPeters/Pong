package interfaces;

/**
 * interface for movable objects
 *
 * @author d.peters
 */
public interface Moveable {

    public void move();

    public void move(int panelWidth, int panelHeight);

    public void moveUp();

    public void moveDown();

    public void moveLeft();

    public void moveRight();
}
