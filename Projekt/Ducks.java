import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.*;

public class Ducks extends JPanel{
    
    private Image background;
    
    public Ducks() {
        initDucks();
    }

    public void initDucks() {
        setBounds(20, 20, 940, 980);

        loadImage();

        // int w = background.getWidth(this);
        // int h = background.getHeight(this);
        setPreferredSize(new Dimension(980, 1080));
    }

    public void loadImage() {
        ImageIcon ii = new ImageIcon("resourses/ducks_background.png");
        background = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }
}
