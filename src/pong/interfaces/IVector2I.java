package pong.interfaces;

/**
 * @author Daniel Peters
 * @version 1.0
 */
public interface IVector2I {

    /**
     *
     * @return
     */
    public int getX();

    /**
     *
     * @param x
     */
    public void setX(int x);

    /**
     *
     * @return
     */
    public int getY();

    /**
     *
     * @return
     */
    public void setY(int y);

    /**
     *
     * @param vector
     */
    public void add(IVector2I vector);

    /**
     *
     * @param vector
     */
    public void sub(IVector2I vector);

    /**
     *
     * @param scalar
     */
    public void mult(int scalar);

    /**
     *
     * @param scalar
     */
    public void div(int scalar);

    /**
     *
     * @return
     */
    public int mag();

    /**
     *
     */
    public void normalize();

    /**
     *
     * @param max
     */
    public void limit(int max);

    /**
     *
     * @param x
     * @param y
     */
    public void set(int x, int y);

    /**
     *
     * @param vector
     */
    public void set(IVector2I vector);


}
