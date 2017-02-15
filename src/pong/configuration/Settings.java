package pong.configuration;

/**
 *
 * @author d.peters
 */
public class Settings {

    /**
     * 
     */
    private int width;
    
    /**
     * 
     */
    private int height;
    
    /**
     * 
     */
    private int victoryCondition;
    
    /**
     * 
     */
    private int gameSpeed;
    
    /**
     * 
     */
    private int ballVelocity;
    
    /**
     * 
     */
    private int playerVelocity;

    /**
     * 
     * @param width
     * @param height
     * @param victoryCondition
     * @param gameSpeed 
     * @param ballVelocity 
     * @param playerVelocity 
     */
    public Settings(
            int width, int height, int victoryCondition, int gameSpeed,
            int ballVelocity, int playerVelocity
    ) {
        this.width = width;
        this.height = height;
        this.victoryCondition = victoryCondition;
        this.gameSpeed = gameSpeed;
        this.ballVelocity = ballVelocity;
        this.playerVelocity = playerVelocity;
    }

    /**
     * 
     * @return 
     */
    public int getWidth() {
        return width;
    }

    /**
     * 
     * @param width 
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * 
     * @return 
     */
    public int getHeight() {
        return height;
    }

    /**
     * 
     * @param height 
     */
    public void setHeight(int height) {
        this.height = height;
    }
    

    /**
     * 
     * @return 
     */
    public int getVictoryCondition() {
        return victoryCondition;
    }

    /**
     * 
     * @param victoryCondition 
     */
    public void setVictoryCondition(int victoryCondition) {
        this.victoryCondition = victoryCondition;
    }

    /**
     * 
     * @return 
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     * 
     * @param gameSpeed 
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    /**
     * 
     * @return 
     */
    public int getBallVelocity() {
        return ballVelocity;
    }

    /**
     * 
     * @param ballVelocity 
     */
    public void setBallVelocity(int ballVelocity) {
        this.ballVelocity = ballVelocity;
    }

    /**
     * 
     * @return 
     */
    public int getPlayerVelocity() {
        return playerVelocity;
    }

    /**
     * 
     * @param playerVelocity 
     */
    public void setPlayerVelocity(int playerVelocity) {
        this.playerVelocity = playerVelocity;
    }
    

}
