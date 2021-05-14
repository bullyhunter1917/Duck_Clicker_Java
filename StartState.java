import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class StartState extends JPanel implements ActionListener {

    private StateMengaer msg;
    private Image background;

    public StartState(StateMengaer msg) {
        this.msg = msg;
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
        b.addActionListener(this);
        b.setActionCommand("START");
        add(b);
    }

    public void loadImage() {
        ImageIcon ii = new ImageIcon("resourses/background_start_screen.jpg");
        background = ii.getImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Drawing background of this state
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "START") {
            //changing game state when we click start button
            msg.change(new Board(msg));
            System.out.println("1");
        } else {
            System.out.println("cos");
        }      
    }
}
