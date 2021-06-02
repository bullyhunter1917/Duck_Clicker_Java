import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class EndState extends JPanel {
    
    private Image background;
    private Image tlo_napisu;

    public EndState() {
        initEndState();
    }

    public void initEndState() {
        this.setLayout(null);

        background = loadImage("game_background.jpg");
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/" + path);
        return ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);
    }
}
