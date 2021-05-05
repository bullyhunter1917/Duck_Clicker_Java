import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener{
    
    private Image background;
    private Image background_ducks;
    private Image background_clicking_area;
    private Image oponent;
    private Enemy oponent_stats;
    private Stats player;
    private Heroes heroes;
    private ArrayList<Heroes> bohaterowie;
    private String[] oponentPath = {"kaczka1_poprawiona.png", "hrabia_Kaczula.png"};

    public Board() {
        initBoard();
    }

    public void initBoard(){
        //Dodanie lewego panelu na którym będą kaczki/bohaterowie
        this.setLayout(null);
        // add(new Ducks());
        // add(new ClickingArea());

        
        player = new Stats();
        heroes = new Heroes("Beat Saber Duck", 1);
        oponent_stats = new Enemy(loadImage("kaczka1_poprawiona.png"));

        background = loadImage("game_background.jpg");
        background_clicking_area = loadImage("ClickingArea_background_wieksze.png");
        background_ducks = loadImage("ducks_background.png");
        oponent = loadImage("kaczka1_poprawiona.png");
        heroes.setIcon(loadImage("szkielekaczor.png"));
        bohaterowie = new ArrayList<Heroes>();
        bohaterowie.add(heroes);

        setPreferredSize(new Dimension(1920, 1080));

        JButton b = new JButton();
        b.setBounds(1000, 60, 820, 940);
        //Setting button invisible
        b.setOpaque(false);
        b.setContentAreaFilled(false);
        b.setBorderPainted(false);
        //Adding actionListener
        b.addActionListener(this);
        b.setActionCommand("Dmg");
        //Adding button to JPanel
        add(b);

        JButton k1 = new JButton();
        k1.setBounds(200,200,100,100);
        k1.addActionListener(this);
        k1.setActionCommand("buy0");
        add(k1);
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
        int x = 300;
        for (Heroes heroes : bohaterowie) {
            g.drawImage(heroes.getIcon(), x, 100, null);
            x+=50;
        }
        g.drawImage(oponent_stats.getImage(), 1000, 80, null);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.RED);
        g.fillRect(1060, 920, (int)(600*oponent_stats.procentHealth()), 50);
        g.setColor(Color.BLACK);
        g.drawString(oponent_stats.getStringHealth(), 1350, 960);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if ((e.getActionCommand()).substring(0,3).equals("buy")) {
            int index = Integer.valueOf(e.getActionCommand().substring(3));
            if(bohaterowie.get(index).canBuy(player.getGold())) {
                player.payGold(bohaterowie.get(index).getPrice());
                bohaterowie.get(index).upgrade();
            }
        }
        else {
        player.counterAdd1();
        oponent_stats.health -= heroes.getDmg();
        if (oponent_stats.health <= 0) {
            Random rand = new Random();
            player.depositGold(player.getLevel()*5/4);
            player.addLevel();
            System.out.println(rand.nextInt(1));
            oponent_stats = new Enemy(player.getLevel(), player.getLevel()*200/11f, loadImage(oponentPath[rand.nextInt(2)]));
            //System.out.println(player.getGold());
        }
        System.out.println(oponent_stats.health);
        }
    }
}
