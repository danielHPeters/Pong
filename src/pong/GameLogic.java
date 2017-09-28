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
package pong;

/**
 * @author d.peters
 */
public class GameLogic {

    /**
     *
     */
    private GameState state;

    /**
     * @param state
     */
    public GameLogic(GameState state) {
        this.state = state;
    }

    /**
     * this method updates all the components on the painter area
     */
    public void update() {

        this.state.getPlayers().forEach((pl) -> {

            // move player
            pl.move();

            // check for collision with ball
            if (this.state.getBall().collision(pl)) {
                this.state.getBall().getVelocity().mult(-1);
            }

            // if a player reaches the victoryCond condition, the painter will end
            if (pl.hasWon(this.state.getConfig().getVictoryCondition())) {
                state.setPlaying(false);
            }

        });

        if (this.state.getBall().collision(this.state.getArea())) {

            if (this.state.getBall().getLocation().getY() == 0 || this.state.getBall().getLocation().getY() < (this.state.getArea().getHeight() - this.state.getBall().getSize())) {
                this.state.getBall().getAcceleration().mult(-1);
            }

        }

        this.state.getBall().move();

        // move the ball


        // check if the ball hit the right border
        if (this.state.getBall().getLocation().getX() > (this.state.getArea().getWidth() - this.state.getBall().getSize())) {
            this.state.getPlayers().get(0).incrementScore();
            this.state.resetGameObjects();
        }

        // check if the ball hit the left border
        if (this.state.getBall().getLocation().getX() == 0) {
            this.state.getPlayers().get(1).incrementScore();
            this.state.resetGameObjects();
        }
    }


    /**
     * @return
     */
    public GameState getState() {
        return state;
    }


}
