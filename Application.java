import javax.swing.JFrame;

public class Application extends JFrame{
    
    public Application() {
        
        initUI();
    }

    private void initUI() {
        
        StateMengaer msg = new StateMengaer(this);

        setSize(1920, 1080);

        setTitle("Duck Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


}
