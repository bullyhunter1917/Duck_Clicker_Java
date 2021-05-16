import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Artefacts implements Serializable {
    private ArrayList<Artefact> artefacts = new ArrayList<Artefact>();
    private long price; 
    private int artefactLeft;
    
    
    public Artefacts(long price) {
        this.price = price;
        this.artefactLeft = 3;
        artefacts.add(new Artefact("Golden Feather", "Gold: x", 1, 2, 100, "szkielekaczor.png"));
        artefacts.add(new Artefact("Sign of wisdom", "Attention: x", 1, 2, 100, "szkielekaczor.png"));
        artefacts.add(new Artefact("smth i do no", "?????: x", 1, 2, 100, "szkielekaczor.png"));
    }

    public boolean canBuy(long money) {
        if (artefactLeft == 0) { return false; }
        else { return money - price >= 0; }
    }

    public Artefact buyArtifact() {
        Random rand = new Random();
        Artefact art = artefacts.remove(rand.nextInt(artefactLeft));
        artefactLeft--;
        price += 100;
        return art;
    }

    public long getPrice() {
        return this.price;
    }

    public int getArtefactsLeft() {
        return artefactLeft;
    }
}
