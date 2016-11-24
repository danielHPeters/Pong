package pong.configuration;

/**
 *
 * @author d.peters
 */
public class Settings {

    private int dimension;
    private int victoryCondition;
    private int gameSpeed;
    private int objectsVelocity;

    public Settings(
            int dimension, int victoryCondition, int gameSpeed,
            int objectsVelocity
    ) {
        this.dimension = dimension;
        this.victoryCondition = victoryCondition;
        this.gameSpeed = gameSpeed;
        this.objectsVelocity = objectsVelocity;
    }

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }

    public int getVictoryCondition() {
        return victoryCondition;
    }

    public void setVictoryCondition(int victoryCondition) {
        this.victoryCondition = victoryCondition;
    }

    public int getGameSpeed() {
        return gameSpeed;
    }

    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    public int getObjectsVelocity() {
        return objectsVelocity;
    }

    public void setObjectsVelocity(int objectsVelocity) {
        this.objectsVelocity = objectsVelocity;
    }
    
    
}
