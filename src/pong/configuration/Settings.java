package pong.configuration;

/**
 *
 * @author d.peters
 */
public class Settings {

    /**
     * 
     */
    private int dimension;
    
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
    private int objectsVelocity;

    /**
     * 
     * @param dimension
     * @param victoryCondition
     * @param gameSpeed
     * @param objectsVelocity 
     */
    public Settings(
            int dimension, int victoryCondition, int gameSpeed,
            int objectsVelocity
    ) {
        this.dimension = dimension;
        this.victoryCondition = victoryCondition;
        this.gameSpeed = gameSpeed;
        this.objectsVelocity = objectsVelocity;
    }

    /**
     * 
     * @return 
     */
    public int getDimension() {
        return dimension;
    }

    /**
     * 
     * @param dimension 
     */
    public void setDimension(int dimension) {
        this.dimension = dimension;
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
    public int getObjectsVelocity() {
        return objectsVelocity;
    }

    /**
     * 
     * @param objectsVelocity 
     */
    public void setObjectsVelocity(int objectsVelocity) {
        this.objectsVelocity = objectsVelocity;
    }

}
