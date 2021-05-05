import java.awt.*;
import java.awt.event.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
    
    private Image background;
    private Image background_ducks;
    private Image background_clicking_area;
    private Image oponent;

    private int x = 1000;

    public Board() {
        initBoard();
    }

    public void initBoard(){
        //Dodanie lewego panelu na którym będą kaczki/bohaterowie
        this.setLayout(null);
        // add(new Ducks());
        // add(new ClickingArea());

        background = loadImage("game_background.jpg");
        background_clicking_area = loadImage("ClickingArea_background_wieksze.png");
        background_ducks = loadImage("ducks_background.png");
        oponent = loadImage("kaczka1_poprawiona.png");


        int w = background.getWidth(this);
        int h = background.getHeight(this);
        setPreferredSize(new Dimension(1920, 1080));

        JButton b = new JButton();
        b.setBounds(1000, 60, 820, 940);
        //Setting button invisible
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        //Adding actionListener
        b.addActionListener(this);
        //Adding button to JPanel
        add(b);
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/"+path);
        return ii.getImage();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        g.drawImage(background_clicking_area, 1000, 500, null);
        g.drawImage(background_ducks, 0, 0, null);
        g.drawImage(oponent, x, 10, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("1");
    }
}
