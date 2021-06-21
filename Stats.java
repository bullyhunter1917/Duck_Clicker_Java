import java.io.Serializable;
import java.util.ArrayList;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Stats implements Serializable {
    
    private long level;
    private long ilosc_klikniec;
    private long gold;
    private long total_gold;
    private int feather;
    private long heroesLevels;
    private int artefactCount;
    private ArrayList<Artefact> owned_Artefacts;
    private ArrayList<Heroes> bohaterowie;
    private final String[] heroesNames = {"Beat Saber Duck", "YasDuck", "Waifu Duck", "PayDuck", "Beat Saber Duck 2.0", "YasDuck 2.0", "Waifu Duck 2.0", "PayDuck 2.0", "Beat Saber Duck 3.0", "YasDuck 3.0", "Waifu Duck 3.0", "PayDuck 3.0", "Beat Saber Duck 4.0", "YasDuck 4.0", "Waifu Duck 4.0", "PayDuck 4.0"};
    private final String[] heroesPath = {"beatsaberkaczka.png", "Yasuokaczka.png", "waifukaczuszka.png", "paydaykaczka.png", "beatsaberkaczka.png", "Yasuokaczka.png", "waifukaczuszka.png", "paydaykaczka.png", "beatsaberkaczka.png", "Yasuokaczka.png", "waifukaczuszka.png", "paydaykaczka.png", "beatsaberkaczka.png", "Yasuokaczka.png", "waifukaczuszka.png", "paydaykaczka.png"};


    public Stats() {
        level = 1;
        ilosc_klikniec = 0;
        gold = 0;
        total_gold = 0;
        feather = 100000;
        heroesLevels = 1;
        artefactCount = 0;
        owned_Artefacts = new ArrayList<Artefact>();
        bohaterowie = new ArrayList<Heroes>();
        int dPrice = 0;
        Heroes Hero;
        for (int i = 0; i < heroesNames.length; i++) {
            if (i == 0) { Hero = new Heroes(heroesNames[i], 1, 1, 1); }
            else { Hero = new Heroes(heroesNames[i], 0, 0, dPrice); }
            bohaterowie.add(Hero);
            dPrice += 10;
        }
    }

    private Image loadImage(String path) {
        ImageIcon ii = new ImageIcon("resourses/" + path);
        return ii.getImage();
    }

    public long getGold() {
        return gold;
    }

    public long getLevel() {
        return level;
    }

    public long getTotalGold() {
        return total_gold;
    }

    public long getIloscKlikniec() {
        return ilosc_klikniec;
    }

    public void addLevel() {
        level++;
    }

    public void payGold(long suma) {
        gold -= suma;
    }

    public void depositGold(long suma) {
        gold += suma;
        total_gold += suma;
    }

    public void counterAdd1() {
        ilosc_klikniec++;
    }

    public void addArtefact(Artefact art) {
        owned_Artefacts.add(art);
        artefactCount += 1;
    }

    public void addHeroesLevels() {
        heroesLevels++;
    }

    public long getHereosLevels() {
        return heroesLevels;
    }

    public int getFeather() {
        return feather;
    }

    public void depositFeathers(int value) {
        feather += value;
    }

    public void payFeather(int price) {
        feather -= price;
    }

    public ArrayList<Artefact> getOwnedArtefacts() {
        return owned_Artefacts;
    }

    public int getArtefactCount() {
        return artefactCount;
    }

    public int getArtefactPower(String name) {
        for (Artefact artefact : owned_Artefacts) {
            if (artefact.getName() == name) {
                return artefact.getPower();
            }
        }
        return 1;
    }

    public Heroes getHeroes(int index) {
        return bohaterowie.get(index);
    }

    public int getHeroesCount() {
        return bohaterowie.size();
    }

    public Image getHeroImage(int index) {
        return loadImage(heroesPath[index]);
    }

    public boolean ifEnd() {
        for (Artefact art : owned_Artefacts) {
            if (art.getName() == "Mrożon" && art.getLevel() >= 10) {
                return true;
            }
        }

        return false;
    }
}
