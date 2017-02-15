package pong;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author d.peters
 */
public class ButtonActions {

    private final GameState game;

    /**
     *
     * @param game
     */
    public ButtonActions(GameState game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    public ItemListener pauseListener() {

        ItemListener listener = (ItemEvent e) -> {

            this.game.pauseToggle();

        };

        return listener;
    }

    /**
     *
     * @return
     */
    public ActionListener restartListener() {

        ActionListener listener = (ActionEvent e) -> {
            this.game.restart();
        };

        return listener;
    }

}
