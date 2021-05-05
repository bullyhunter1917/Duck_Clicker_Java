import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

public class ClickingArea extends JPanel implements ActionListener {
    
    private Image background;
    private Image opponent;
    
    public ClickingArea() {
        initClickingArea();
    }

    public void initClickingArea() {
        this.setLayout(null);
        setBounds(1000, 20, 1920, 1000);
        loadImage();
        setPreferredSize(new Dimension(980,1080));
    
        JButton b = new JButton();
        b.setBounds(0, 0, 800, 900);
        //Setting button invisible
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        //Adding actionListener
        b.addActionListener(this);
        //Adding button to JPanel
        add(b);

        loadOpponent();
    }

    public void actionPerformed(ActionEvent e) {
        System.out.println("1");
    }

    public void loadImage() {
        ImageIcon ii = new ImageIcon("resourses/ClickingArea_background_wieksze.png");
        background = ii.getImage();
    }

    public void loadOpponent() {
        ImageIcon ii = new ImageIcon("resourses/kaczka1_poprawiona.png");
        opponent = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        g.drawImage(background, 50, 500, null);
        g.drawImage(opponent, 0, 0, null);
    }
}
