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

    private final RunGame loop;
    Thread executer;

    /**
     *
     * @param loop
     */
    public ButtonActions(RunGame loop) {
        this.loop = loop;
    }

    /**
     *
     * @return
     */
    public ItemListener pauseListener() {

        ItemListener listener = (ItemEvent e) -> {

            loop.pauseToggle();

        };

        return listener;
    }

    /**
     *
     * @return
     */
    public ActionListener restartListener() {

        ActionListener listener = (ActionEvent e) -> {
            this.loop.restartGame();
        };

        return listener;
    }

}
