import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Board extends JPanel implements ActionListener {
    
    private StateMengaer msg;

    private int page;
    //Images
    private Image background;
    private Image background_ducks;
    private Image background_clicking_area;
    private Image gold_background;
    private Image buy_button;
    private Image gold_icon;
    //Must have classes
    private Enemy oponent_stats;
    private Stats player;
    private Artefacts artefacts;
    //Buttons for artefacts
    private JButton buyArtefact;
    private JButton restart;
    private ArrayList<JButton> buyArtefacts;
    //Arrays for heroes buy buttons
    private ArrayList<JButton> buy_buttons;
    //String arrays for constant values
    private final String[] oponentPath = {"kaczka1_poprawiona.png", "hrabia_Kaczula.png"};
    
    public Board() {
        initBoard();
    }

    public Board(StateMengaer msg) {
        this.msg = msg;
        initBoard();
    }

    public void initBoard(){
        this.setLayout(null);

        //Initing artefacts
        artefacts = new Artefacts(100);

        page = 0;

        //Creating buttons for pages
        int dx = 20;
        for (int i = 0; i < 7; i++) {
            JButton button = new JButton();
            button.setBounds(dx, 120, 70, 70);
            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);                       
            button.addActionListener(this);
            button.setActionCommand(String.valueOf(i));

            dx += 99;
            add(button);
        }

        //Creating buy buttons
        buy_buttons = new ArrayList<JButton>();
        int dy = 250;
        for (int i = 0; i < 4; i++) {
            JButton button = new JButton();
            button.setBounds(50, dy, 140, 60);

            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);

            button.addActionListener(this);
            button.setActionCommand("buy"+i);
            buy_buttons.add(button);
            add(button);
            dy += 200;
        }

        //Creating buyArtefacts buttons
        buyArtefacts = new ArrayList<JButton>();
        dy = 550;
        for (int j = 0; j < 3; j++) {
            JButton button = new JButton();
            button.setBounds(50, dy, 140, 60);
            button.setEnabled(false);

            button.setOpaque(false);
            button.setContentAreaFilled(false);
            button.setBorderPainted(false);

            button.addActionListener(this);
            button.setActionCommand("BUY"+j);
            buyArtefacts.add(button);
            add(button);
            dy += 150;
        }


        //Adding attack button
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

        //Buy Artefact button
        buyArtefact = new JButton();
        buyArtefact.setBounds(400, 360, 140, 60);
        buyArtefact.setOpaque(false);
        buyArtefact.setContentAreaFilled(false);
        buyArtefact.setBorderPainted(false);
        buyArtefact.addActionListener(this);
        buyArtefact.setActionCommand("Artefact");
        buyArtefact.setEnabled(false);
        add(buyArtefact);

        restart = new JButton();
        restart.setBounds(400, 420, 140, 60);
        restart.setOpaque(false);
        restart.setContentAreaFilled(false);
        restart.setBorderPainted(false);
        restart.addActionListener(this);
        restart.setActionCommand("RESTART");
        restart.setEnabled(false);
        add(restart);
        
        player = new Stats();
        
        //Init oponent
        oponent_stats = new Enemy(loadImage("kaczka1_poprawiona.png"));

        //Adding images
        background = loadImage("game_background.jpg");
        background_clicking_area = loadImage("ClickingArea_background_wieksze.png");
        background_ducks = loadImage("ducks_background_page1.png");
        gold_background = loadImage("coin_background.png");
        buy_button = loadImage("buy_button.jpg");
        gold_icon = loadImage("coin_icon.png");
        

        

        setPreferredSize(new Dimension(1920, 1080));


        //DPS - timer który co sekundę zadaje obrażenia oponentowi
        Timer timer = new Timer();
        TimerTask myTask = new TimerTask(){
            @Override
            public void run() {
                int suma = 0;
                for (int i = 1; i < player.getHeroesCount(); i++) {
                    suma += player.getHeroes(i).getDmg();
                }
                oponent_stats.health -= suma;
                if (oponent_stats.health <= 0) {
                    Random rand = new Random();
                    player.depositGold(oponent_stats.getLevel()*5/4);
                    player.addLevel();
                    oponent_stats = new Enemy(player.getLevel(), player.getLevel()*120/11f, loadImage(oponentPath[rand.nextInt(2)]));
                }
                repaint();
            }
        };

        timer.schedule(myTask, 1000, 1000);
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/"+path);
        return ii.getImage();
    }

    private Image loadPage(int page) {
        ImageIcon ii = new ImageIcon("resourses/ducks_background_page" + String.valueOf(page + 1) + ".png");
        return ii.getImage();
    }

    private void changeHeroesBuyButtons(boolean z) {
        for (JButton button : buy_buttons) {
            button.setEnabled(z);
        }
    }

    private void changeArtefactsBuyButtons(boolean z) {
        for (JButton button : buyArtefacts) {
            button.setEnabled(z);
        }
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //Background images
        g.drawImage(background, 0, 0, null);
        g.drawImage(background_clicking_area, 1000, 500, null);
        //Drawing pages
        g.drawImage(loadPage(page), 0, 80, null);
        g.drawImage(gold_background, 0, 0, null);
        g.drawImage(gold_icon, 30, 2, null);
        g.drawImage(gold_icon, 580, 2, null);
        //Enemy image
        g.drawImage(oponent_stats.getImage(), 1000, 80, null);
        //Health bar
        g.setFont(new Font("TimesRoman", Font.PLAIN, 40));
        g.setColor(Color.RED);
        g.fillRect(1060, 920, (int)(600*oponent_stats.procentHealth()), 50);
        g.setColor(Color.BLACK);
        g.drawString(oponent_stats.getStringHealth(), 1350, 960);
        //Gold
        g.drawString("Silver: " + String.valueOf(player.getGold()), 200, 70);
        //Level/Name/Price of Heroes
        int y = 250;
        if(page < 4) {
            restart.setEnabled(false);
            buyArtefact.setEnabled(false);
            changeArtefactsBuyButtons(false);
            changeHeroesBuyButtons(true);
            for (int i = page*4; i < page*4 + 4; i++) {
                g.drawImage(player.getHeroes(i).getIcon(), 540, y-20, null);
                g.drawImage(buy_button, 50, y, null);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
                g.drawString(player.getHeroes(i).getName(), 200, y+20);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
                g.drawString("Level: " + player.getHeroes(i).getLevel(), 200, y+50);
                g.drawString("Price: " + player.getHeroes(i).getPrice(), 200, y+80);
                y += 200;
            }
        }
        //Artifact page
        else if (page == 4) {
            changeHeroesBuyButtons(false);
            changeArtefactsBuyButtons(true);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.drawString("Owned Artifacts", 100, 300);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("Feathers: " + player.getFeather(), 100, 400);
            g.drawString("Price: " + artefacts.getPrice(), 100, 450);
            if (player.getLevel() < 500) {
                g.drawImage(buy_button, 400, 420, null);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
                g.drawString("Can restart after lvl 500", 400, 500);
                g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            }
            else {
                restart.setEnabled(true);
                g.drawImage(buy_button, 400, 420, null);
            }
            
            if (artefacts.getArtefactsLeft() > 0) {
                buyArtefact.setEnabled(true);
                g.drawImage(buy_button, 400, 360, null);  
            } else {
                buyArtefact.setEnabled(false);
                g.drawImage(buy_button, 400, 360, null);
            }
            
            int dy = 550;
            for (Artefact artefact : player.getOwnedArtefacts()) {
                g.drawString(artefact.getName(), 200, dy);
                g.drawString(artefact.getEfect() + artefact.getPower(), 200, dy+30);
                g.drawImage(artefact.getIcon(), 500, dy-30, null);
                g.drawString("Level: " + artefact.getLevel(), 200, dy + 60);
                g.drawString("Price: " + artefact.getPrice(), 200, dy + 90);
                g.drawImage(buy_button, 50, dy, null);
                dy+=150;
            }
        }
        //Stats of player
        else if (page == 5) {
            restart.setEnabled(false);
            buyArtefact.setEnabled(false);
            changeHeroesBuyButtons(false);
            changeArtefactsBuyButtons(false);
            //Dodać Heroes Level, APS - attention per second, owned fethers 
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.drawString("Stats", 270, 300);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
            g.drawString("Level: " + player.getLevel(), 50, 400);
            g.drawString("Ilość Kliknięć: " + player.getIloscKlikniec(), 50, 450);
            g.drawString("Zarobione srebro: " + player.getTotalGold(), 50, 500);
            g.drawString("Click Attention: " + player.getHeroes(0).getDmg(), 50, 550);
            g.drawString("Heroes Levels: " + player.getHereosLevels(), 50, 600);
            g.drawString("Fethers: " + player.getFeather(), 50, 650);
        }
        //Setting
        else {
            restart.setEnabled(false);
            buyArtefact.setEnabled(false);
            changeHeroesBuyButtons(false);
            changeArtefactsBuyButtons(false);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 60));
            g.drawString("Settings", 220, 300);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Page buttons
        if (e.getActionCommand().length() == 1) {
            page = Integer.valueOf(e.getActionCommand());
            for (int i = 0; i < 4; i++) {
                buy_buttons.get(i).setActionCommand("buy"+(page*4+i));
            }
            this.repaint();
        }
        else if (e.getActionCommand() == "RESTART") {
            int feather = player.getFeather();
            long temp = player.getHereosLevels() + player.getLevel();
            ArrayList<Artefact> artefacts = player.getOwnedArtefacts();
            player = new Stats();
            player.depositFeathers(feather + (int)(temp/10));
            for (Artefact artefact : artefacts) {
                player.addArtefact(artefact);
            }
            oponent_stats = new Enemy(player.getLevel(), player.getLevel()*120/11f, loadImage(oponentPath[0]));

            restart.setEnabled(false);

            this.repaint();
        }
        else if (e.getActionCommand() == "Artefact") {
            if (artefacts.canBuy(player.getFeather())) {
                player.payFeather((int)artefacts.getPrice());
                player.addArtefact(artefacts.buyArtifact());
                this.repaint();
            }
        }
        //Attack button
        else if (e.getActionCommand() == "Dmg"){
            player.counterAdd1();
            oponent_stats.health -= player.getHeroes(0).getDmg()*player.getArtefactPower("Sign of wisdom");
            if (oponent_stats.health <= 0) {
                Random rand = new Random();
                player.depositGold((oponent_stats.getLevel()*5/4) * player.getArtefactPower("Golden Feather"));
                player.addLevel();
                oponent_stats = new Enemy(player.getLevel(), player.getLevel()*120/11f, loadImage(oponentPath[rand.nextInt(2)]));
            }
            this.repaint();
        }
        //Buy Artefacts buttons
        else if ((e.getActionCommand()).substring(0,3).equals("BUY")) {
            int index = Integer.valueOf(e.getActionCommand().substring(3));
            if (player.getOwnedArtefacts().get(index).canUpgrade(player.getFeather())) {
                player.payFeather(player.getOwnedArtefacts().get(index).getPrice());   
                player.getOwnedArtefacts().get(index).upgrade(1);             
                this.repaint();
            }
        }
        //Buy buttons
        else if ((e.getActionCommand()).substring(0,3).equals("buy")) {
            int index = Integer.valueOf(e.getActionCommand().substring(3));
            if(player.getHeroes(index).canBuy(player.getGold())) {
                player.payGold(player.getHeroes(index).getPrice());
                player.getHeroes(index).upgrade();
                player.addHeroesLevels();
                this.repaint();
            }
        }
    }
}
