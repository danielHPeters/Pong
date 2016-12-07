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

    RunGame loop;
    Thread executer;

    /**
     *
     * @param loop
     * @param executer
     */
    public ButtonActions(RunGame loop, Thread executer) {
        this.loop = loop;
        this.executer = executer;
    }

    /**
     *
     * @return
     */
    public ItemListener pauseListener() {

        ItemListener listener = (ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                loop.setPaused(true);
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                loop.setPaused(false);
            }

        };

        return listener;
    }

    /**
     *
     * @return
     */
    public ActionListener restartListener() {

        ActionListener listener = (ActionEvent e) -> {
            this.executer.interrupt();
        };

        return listener;
    }
}
