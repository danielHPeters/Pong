/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.util.ArrayList;
import java.util.List;
import pong.gameObjcects.Ball;
import pong.gameObjcects.GameArea;
import pong.gameObjcects.Player;

/**
 *
 * @author Daniel
 */
public class GameState {
    
    /**
     *
     */
    private final GameArea area;
    
    /**
     *
     */
    private final Ball ball;

    /**
     *
     */
    private final List<Player> players;
    
    /**
     * 
     * @param width
     * @param height 
     */
    public GameState(int width, int height){
        this.area = new GameArea(width - 10, height - 80);
        Player pl1 = new Player(2 * 5, area.getHeight() / 2);
        Player pl2 = new Player(width - 4 * 5, area.getHeight() / 2);
        this.players = new ArrayList<>();
        this.players.add(pl1);
        this.players.add(pl2);
        this.ball = new Ball(width / 2, height / 2);
    }

    public List<Player> getPlayers() {
        return players;
    }

    public GameArea getArea() {
        return area;
    }

    public Ball getBall() {
        return ball;
    }
    
    
    
}
