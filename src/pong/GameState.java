package pong;

import java.util.ArrayList;
import java.util.List;
import pong.configuration.Settings;
import pong.models.Ball;
import pong.models.GameArea;
import pong.models.Player;

/**
 *
 * @author Daniel
 */
public class GameState {

    /**
     *
     */
    private boolean playing;

    /**
     *
     */
    private boolean paused;

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
    private final Settings config;

    /**
     *
     */
    private final List<Player> players;

    /**
     *
     * @param config
     */
    public GameState(Settings config) {
        this.config = config;
        this.area = new GameArea(config.getWidth() - 10, config.getHeight() - 80);
        Player pl1 = new Player(2 * 5, area.getHeight() / 2, config.getPlayerVelocity());
        Player pl2 = new Player(config.getWidth() - 4 * 5, area.getHeight() / 2, config.getPlayerVelocity());
        this.players = new ArrayList<>();
        this.players.add(pl1);
        this.players.add(pl2);
        this.ball = new Ball(config.getWidth() / 2, config.getHeight() / 2, config.getBallVelocity());
        this.playing = true;
        this.paused = false;
    }

    /**
     * 
     * @return 
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     * 
     * @return 
     */
    public GameArea getArea() {
        return area;
    }

    /**
     * 
     * @return 
     */
    public Ball getBall() {
        return ball;
    }

    /**
     *
     * @return
     */
    public boolean isPlaying() {
        return playing;
    }

    /**
     *
     * @param playing
     */
    public void setPlaying(boolean playing) {
        this.playing = playing;
    }

    /**
     *
     */
    public void pauseToggle() {
        this.paused = !paused;
    }

    /**
     * 
     * @return 
     */
    public boolean isPaused() {
        return paused;
    }

    /**
     * 
     * @return 
     */
    public Settings getConfig() {
        return config;
    }

    /**
     *
     */
    public void resetGameObjects() {
        this.getBall().resetPosition();
        this.getPlayers().forEach(player -> player.resetPosition());
    }

    /**
     *
     */
    public void resetScores() {
        this.getPlayers().forEach(player -> player.resetScore());
    }

    /**
     *
     */
    public void restart() {
        resetGameObjects();
        resetScores();
        this.setPlaying(true);
    }

}
