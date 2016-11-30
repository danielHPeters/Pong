package pong;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author d.peters
 */
public class ButtonActions {

    RunGame loop;
    
    public ButtonActions(RunGame loop){
        this.loop = loop;
    }

    public  ItemListener pauseListener() {

        ItemListener listener = (ItemEvent e) -> {

            if (e.getStateChange() == ItemEvent.SELECTED) {
                loop.setPaused(true);
            } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                loop.setPaused(false);
            }

        };

        return listener;
    }
}
