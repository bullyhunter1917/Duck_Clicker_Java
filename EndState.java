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
        tlo_napisu = loadImage("tlo_napisu_start.png");
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/" + path);
        return ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(background, 0, 0, null);
        g.drawImage(tlo_napisu, 590, 100, null);
        g.setFont(new Font("Noto", Font.PLAIN, 120));
        g.drawString("Thanks", 750, 200);
        g.drawString("for", 870, 320);
        g.drawString("playing", 760, 430);
    }
}
