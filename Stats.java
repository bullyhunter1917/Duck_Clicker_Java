import java.io.Serializable;
import java.util.ArrayList;

public class Stats implements Serializable {
    private long level;
    private long ilosc_klikniec;
    private long gold;
    private long total_gold;
    private int feather;
    private long heroesLevels;
    private int artefactCount;
    private ArrayList<Artefact> owned_Artefacts;

    public Stats() {
        level = 1;
        ilosc_klikniec = 0;
        gold = 0;
        total_gold = 0;
        feather = 0;
        heroesLevels = 1;
        owned_Artefacts = new ArrayList<Artefact>();
        owned_Artefacts.add(new Artefact("Golden Feather", "Gold: x", 1, 2, 100, "szkielekaczor.png"));
        owned_Artefacts.add(new Artefact("Sign of wisdom", "Attention: x", 1, 2, 100, "szkielekaczor.png"));
        owned_Artefacts.add(new Artefact("smth i do no", "?????: x", 1, 2, 100, "szkielekaczor.png"));
        artefactCount = 3;
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
}
