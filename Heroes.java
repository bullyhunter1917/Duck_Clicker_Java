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
        dmg *= level*7/10;
        price *= level*2;
    }

}
