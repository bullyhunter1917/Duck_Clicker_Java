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
    private Image gold_background;
    private Image buy_button;
    private Image gold_icon;
    private Enemy oponent_stats;
    private Stats player;
    private Heroes attacHero;
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
        attacHero = new Heroes("Beat Saber Duck", 1);
        oponent_stats = new Enemy(loadImage("kaczka1_poprawiona.png"));

        background = loadImage("game_background.jpg");
        background_clicking_area = loadImage("ClickingArea_background_wieksze.png");
        background_ducks = loadImage("ducks_background.png");
        gold_background = loadImage("coin_background.png");
        buy_button = loadImage("buy_button.jpg");
        gold_icon = loadImage("coin_icon.png");
        
        attacHero.setIcon(loadImage("szkielekaczor.png"));
        bohaterowie = new ArrayList<Heroes>();
        bohaterowie.add(attacHero);

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
        k1.setBounds(100,250,140,60);

        k1.setOpaque(false);
        k1.setContentAreaFilled(false);
        k1.setBorderPainted(false);

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
        //Background images
        g.drawImage(background, 0, 0, null);
        g.drawImage(background_clicking_area, 1000, 500, null);
        g.drawImage(background_ducks, 0, 100, null);
        g.drawImage(gold_background, 0, 0, null);
        g.drawImage(gold_icon, 30, 2, null);
        g.drawImage(gold_icon, 580, 2, null);
        //Obrazek przeciwnika
        g.drawImage(oponent_stats.getImage(), 1000, 80, null);
        //Pasek życia z ilością życia
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.RED);
        g.fillRect(1060, 920, (int)(600*oponent_stats.procentHealth()), 50);
        g.setColor(Color.BLACK);
        g.drawString(oponent_stats.getStringHealth(), 1350, 960);
        //Gold
        g.drawString("Gold: " + String.valueOf(player.getGold()), 200, 70);
        //Level bohaterów
        int y = 250;
        for (Heroes heroes : bohaterowie) {
            g.drawImage(heroes.getIcon(), 470, y-20, null);
            g.drawImage(buy_button, 100, y, null);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("Level: " + heroes.getLevel(), 250, 270);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
            g.drawString("Price: " + heroes.getPrice(), 250, 330);
            y += 50;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Przycisk kupna
        if ((e.getActionCommand()).substring(0,3).equals("buy")) {
            int index = Integer.valueOf(e.getActionCommand().substring(3));
            if(bohaterowie.get(index).canBuy(player.getGold())) {
                player.payGold(bohaterowie.get(index).getPrice());
                bohaterowie.get(index).upgrade();
                this.repaint();
            }
            System.out.println("buy");
        }
        //Atakowanie przeciwnika
        else {
        player.counterAdd1();
        oponent_stats.health -= attacHero.getDmg();
        if (oponent_stats.health <= 0) {
            Random rand = new Random();
            player.depositGold(oponent_stats.getLevel()*5/4);
            player.addLevel();
            System.out.println(rand.nextInt(1));
            oponent_stats = new Enemy(player.getLevel(), player.getLevel()*120/11f, loadImage(oponentPath[rand.nextInt(2)]));
            //System.out.println(player.getGold());\
            this.repaint();
        }
        System.out.println(oponent_stats.health);
        }
    }
}
