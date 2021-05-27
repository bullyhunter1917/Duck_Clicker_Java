import javax.swing.JFrame;
import javax.swing.JPanel;

public class Application extends JFrame{
    
    public Application(JPanel state) {
        initUI(state);
    }

    private void initUI(JPanel state) {

        //StateMengaer msg = new StateMengaer(this);
        
        add(state);

        setSize(1920, 1080);

        setTitle("Duck Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


}