import javax.swing.*;
import java.awt.*;

public class StartState extends JPanel {

    private Image background;

    public StartState() {
        initStartState();
    }

    public void initStartState() {
        this.setLayout(null);

        loadImage();

        int w = background.getWidth(this);
        int h = background.getHeight(this);
        setPreferredSize(new Dimension(w, h));
        
        JButton b = new JButton("START");
        //b.setPreferredSize(new Dimension(100,50));
        b.setBounds(w/2-200, h/2+200, 400, 100);
        add(b);
        
        
    }


    public void loadImage() {
        ImageIcon ii = new ImageIcon("resourses/background_start_screen.jpg");
        background = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
