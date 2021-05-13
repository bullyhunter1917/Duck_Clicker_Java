import java.awt.*;

public class Heroes {
    private String name;
    private long dmg;
    private long price;
    private long level;
    private Image icon;

    public Heroes(String name, long level) {
        this.name = name;
        this.dmg = level*10/9;
        this.price = level*10/7;
        this.level = 1;
    }

    public Heroes(String name, long level, long dmg, long price) {
        this.name = name;
        this.level = level;
        this.dmg = dmg;
        this.price = price;
    }

    public void setIcon(Image icon) {
       this.icon = icon;
    }

    public Image getIcon() {
        return icon;
    }

    public long getDmg() {
        return dmg;
    }

    public long getPrice() {
        return price;
    }

    public boolean canBuy(long money) {
        return money-price>=0;
    }

    public void upgrade() {
        level++;
        dmg += level*6/10;
        price += level*17/10;
    }

    public String getLevel() {
        return String.valueOf(level);
    }

}
