public class Stats {
    private long level;
    private long ilosc_klikniec;
    private long gold;

    public Stats() {
        level = 1;
        ilosc_klikniec = 0;
        gold = 0;
    }

    public long getGold() {
        return gold;
    }

    public long getLevel() {
        return level;
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
    }

    public void counterAdd1() {
        ilosc_klikniec++;
    }
}
