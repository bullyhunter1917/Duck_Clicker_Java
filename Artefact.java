import java.awt.Image;
import java.io.Serializable;

import javax.swing.ImageIcon;

public class Artefact implements Serializable{
    private String name;
    private String efect;
    private int level;
    private int power;
    private int price;
    private transient Image icon;

    public Artefact(String name, String efect, int level, int power, int price, String path) {
        this.name = name;
        this.efect = efect;
        this.level = level;
        this.power = power;
        this.price = price;
        icon = loadImage(path);
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/" + path);
        return ii.getImage();
    }

    public boolean canUpgrade(int fethers) {
        return fethers-price >= 0;
    } 

    public void upgrade(int wzmocnienie) {
        level ++;
        price *= 2;
        power += wzmocnienie;
    }

    public String getName() {
        return name;
    }

    public String getEfect() {
        return efect;
    }

    public int getLevel() {
        return level;
    }

    public int getPower() {
        return power;
    }

    public int getPrice() {
        return price;
    }

    public Image getIcon() {
        return icon;
    }
}
