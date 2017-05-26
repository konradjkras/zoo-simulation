package pl.tarnow.iilo.zoo;



import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String description;
    private List<Animal> inhabitants;
    private EnclosureType enclosureType;

    public String getDescription() {
        return description;
    }

    public Enclosure(EnclosureType enclosureType, String description) {
        this.description = description;
        this.enclosureType = enclosureType;
        inhabitants = new ArrayList<>();
    }
    public void changeDescription(String newDescription){ this.description=newDescription;}
    public EnclosureType getEnclosureType(){
        return enclosureType;
    }
    public void addInhabitant(Animal animal){
        inhabitants.add(animal);
    }
    @Override
    public String toString() {
        return getDescription();
    }

    public List<Animal> getInhabitants() {
        return inhabitants;
    }

    public void removeInhabitant(Animal animal) {
        inhabitants.remove(animal);
    }

    public static Enclosure createEnclosure(EnclosureType enclosureType){
        return new Enclosure(enclosureType,enclosureType+" default name");
    }
}
