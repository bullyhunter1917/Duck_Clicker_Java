import java.awt.*;


public class Enemy {
    private String imagePath;
    private long level;
    private final float fullHealth;
    public float health;

    public Enemy() {
        this.level = -1;
        this.health = 10;
        this.imagePath = "kaczka1_poprawiona.png";
        this.fullHealth = health;
    }

    public Enemy(long lvl, float health, String imagePath){
        this.level = lvl;
        this.health = health;
        this.imagePath = imagePath;
        this.fullHealth = health;
    }

    public long getLevel() {
        return level;
    }

    public String getPath() {
        return imagePath;
    }

    public float procentHealth() {
        return health/fullHealth;
    }
}
