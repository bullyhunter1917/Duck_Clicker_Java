import javax.swing.JFrame;

public class Application extends JFrame{
    
    public Application() {
        
        initUI();
    }

    private void initUI() {
        
        add(new Board());

        setSize(1920, 1080);

        setTitle("Duck Clicker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }


}
