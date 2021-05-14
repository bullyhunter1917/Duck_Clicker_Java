import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class StateMengaer {
    private JFrame window;
    private JPanel state;

    public StateMengaer(JFrame window) {
        this.window = window;
        this.state = new StartState(this);
        window.add(state);
    }

    public void change(JPanel state) {
        window.remove(this.state);
        this.state = state;
        window.add(state);
    }
}
