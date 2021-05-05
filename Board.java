import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Board extends JPanel{
    
    private Image bardejov;

    public Board() {
        initBoard();
    }

    public void initBoard(){
        //Dodanie lewego panelu na którym będą kaczki/bohaterowie
        this.setLayout(null);
        add(new Ducks());
        add(new ClickingArea());

        loadImage();

        int w = bardejov.getWidth(this);
        int h = bardejov.getHeight(this);
        setPreferredSize(new Dimension(w, h));
    }

    private void loadImage() {
        ImageIcon ii = new ImageIcon("resourses/game_background.jpg");
        bardejov = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g){
        g.drawImage(bardejov, 0, 0, null);
    }
}
