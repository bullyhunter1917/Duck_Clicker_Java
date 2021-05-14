import java.awt.Dimension;
import java.awt.Image;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GameEnd extends JPanel {
    
    private Image background;
    
    public GameEnd() {
        this.setLayout(null);

        background = loadImage();

        setPreferredSize(new Dimension(1920, 1080));
    }

    public Image loadImage() {
        ImageIcon ii = new ImageIcon("resourses/background_start_screen");
        return ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
    }
}
