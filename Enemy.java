import java.awt.*;


public class Enemy {
    private Image icon;
    private long level;
    private final float fullHealth;
    public float health;

    public Enemy(Image icon) {
        this.level = -1;
        this.health = 10;
        this.icon = icon;
        this.fullHealth = health;
    }

    public Enemy(long lvl, float health, Image icon){
        this.level = lvl;
        this.health = health;
        this.icon = icon;
        this.fullHealth = health;
    }

    public long getLevel() {
        return level;
    }

    public Image getImage() {
        return icon;
    }

    public float procentHealth() {
        return health/fullHealth;
    }

    public String getStringHealth() {
        return String.valueOf((int)health);
    }
}
