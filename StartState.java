import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartState extends JPanel implements ActionListener {

    private StateMengaer msg;
    private Image background;
    private Image play_button;
    private Image tlo_napisu;

    public StartState(StateMengaer msg) {
        this.msg = msg;
        initStartState();
    }

    public void initStartState() {
        this.setLayout(null);

        background = loadImage("game_background.jpg");
        play_button = loadImage("play_button.png");
        tlo_napisu = loadImage("tlo_napisu_start.png");

        setPreferredSize(new Dimension(1920,1080));
        
        JButton b = new JButton();
        b.setBounds(710, 740, 500, 150);
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        b.addActionListener(this);
        b.setActionCommand("START");
        add(b);
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/" + path);
        return ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Drawing background of this state
        g.drawImage(background, 0, 0, null);
        g.drawImage(tlo_napisu, 590, 80, null);
        g.setFont(new Font("Noto", Font.PLAIN, 120));
        g.drawString("Welcome", 730, 180);
        g.drawString("to", 900, 300);
        g.drawString("Duck Clicker", 630, 420);
        g.drawImage(play_button, 710, 740, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "START") {
            //changing game state when we click start button
            msg.change(new Board(msg));
        }       
    }
}
