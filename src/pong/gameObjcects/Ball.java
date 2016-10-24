package pong.gameObjcects;

/**
 * this class describes a ball object, its movement functions etc.
 * @author d.peters
 */
public class Ball extends MovableObject {
    
    /**
     * Default constructor setting position, speed, width, height
     * @param xPos initial x position
     * @param yPos initial y position
     */
    public Ball(int xPos, int yPos) {
        this.up = true;
        this.right = false;
        this.x = xPos;
        this.y = yPos;
        this.speed = 5;
        this.width = 8;
        this.height = 8;
    }

    /**
     * getter for the site of ball
     * @return current size
     */
    public int getSize() {
        return width;
    }

    /**
     * setter for the site of ball (width and height)
     * @param size new size
     */
    public void setSize(int size) {
        this.width = size;
        this.height = size;
    }

    /**
     * move the ball
     * @param panelWidth width of the panel
     * @param panelHeight height of the panel
     */
    public void move(int panelWidth, int panelHeight) {
        moveHor(panelWidth);
        moveVert(panelHeight);
    }

    /**
     * move in the horizontal direction
     * @param panelWidth width of the game area
     */
    public void moveHor(int panelWidth) {
        if (this.right) {
            moveRight();
            if (this.x >= (panelWidth - this.getSize())) {
                this.right = false;
            }
        } else {
            moveLeft();
            if (this.x <= 0) {
                this.right = true;
            }
        }
    }

    /**
     * Move in the vertical direcction
     * @param panelHeight height of the game area (used for moving down)
     */
    public void moveVert(int panelHeight) {
        if (this.up) {
            moveUp();
            if (this.y <= 0) {
                this.up = false;
            }
        } else {
            moveDown();
            if (this.y >= (panelHeight - this.getSize())) {
                this.up = true;
            }
        }
    }

    /**
     * changes vertical direction to the opposite direction
     */
    public void changeHorDir() {
        if (this.right) {
            this.right = false;
        } else {
            this.right = true;
        }
    }

    /**
     * checks for collision with player objects
     * @param pl player object
     * @return boolean which tells if there was a collision with the player object
     */
    public boolean collision(Player pl) {
        boolean coll = false;
        if (pl.getBounds().intersects(this.getBounds())) {
            coll = true;
        }
        return coll;
    }
}
