import java.util.ArrayList;
import java.util.Random;

public class Artefacts {
    private ArrayList<Artefact> artefacts = new ArrayList<Artefact>();
    private long price; 
    private int artefactLeft;
    Random rand = new Random();
    
    public Artefacts(long price) {
        this.price = price;
        this.artefactLeft = 3;
        artefacts.add(new Artefact("Golder Feather", "Ducks drop more gold: x", 1, 2, 100));
        artefacts.add(new Artefact("Sign of wisdom", "Clicking give more attention to ducks: x", 1, 2, 100));
        artefacts.add(new Artefact("smth i do no", "?????", 1, 2, 100));
    }

    public boolean canBuy(long money) {
        if (artefactLeft == 0) { return false; }
        else { return price-money >= 0; }
    }

    public Artefact buyArtifact() {
        Artefact art = artefacts.remove(rand.nextInt(artefactLeft));
        artefactLeft--;
        price += 100;
        return art;
    }
}
