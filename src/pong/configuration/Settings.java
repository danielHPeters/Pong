/*
 * Copyright (C) 2017 Daniel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pong.configuration;

/**
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
    private int ballSpeed;

    /**
     *
     */
    private int playerSpeed;

    /**
     * @param width
     * @param height
     * @param victoryCondition
     * @param gameSpeed
     * @param ballSpeed
     * @param playerSpeed
     */
    public Settings(
            int width, int height, int victoryCondition, int gameSpeed,
            int ballSpeed, int playerSpeed
    ) {
        this.width = width;
        this.height = height;
        this.victoryCondition = victoryCondition;
        this.gameSpeed = gameSpeed;
        this.ballSpeed = ballSpeed;
        this.playerSpeed = playerSpeed;
    }

    /**
     * @return
     */
    public int getWidth() {
        return width;
    }

    /**
     * @param width
     */
    public void setWidth(int width) {
        this.width = width;
    }

    /**
     * @return
     */
    public int getHeight() {
        return height;
    }

    /**
     * @param height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * @return
     */
    public int getVictoryCondition() {
        return victoryCondition;
    }

    /**
     * @param victoryCondition
     */
    public void setVictoryCondition(int victoryCondition) {
        this.victoryCondition = victoryCondition;
    }

    /**
     * @return
     */
    public int getGameSpeed() {
        return gameSpeed;
    }

    /**
     * @param gameSpeed
     */
    public void setGameSpeed(int gameSpeed) {
        this.gameSpeed = gameSpeed;
    }

    /**
     * @return
     */
    public int getBallSpeed() {
        return ballSpeed;
    }

    /**
     * @param ballSpeed
     */
    public void setBallSpeed(int ballSpeed) {
        this.ballSpeed = ballSpeed;
    }

    /**
     * @return
     */
    public int getPlayerSpeed() {
        return playerSpeed;
    }

    /**
     * @param playerSpeed
     */
    public void setPlayerSpeed(int playerSpeed) {
        this.playerSpeed = playerSpeed;
    }

}
