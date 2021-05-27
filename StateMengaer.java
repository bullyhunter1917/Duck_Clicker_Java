import javax.swing.JPanel;

public class StateMengaer {
    private Application app;
    

    public StateMengaer() {
        app = new Application(new StartState(this));
        app.setVisible(true);
    }

    public void change(JPanel state) {
        app.dispose();
        app = new Application(state);
        app.setVisible(true);
    }

}
