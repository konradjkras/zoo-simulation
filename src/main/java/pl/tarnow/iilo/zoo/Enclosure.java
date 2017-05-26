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

    public Enclosure(String enclosureType, String description) {
        this.description = description;
        inhabitants = new ArrayList<>();
    }

    public void addInhabitant(Animal animal){
        if(animal.getEnclosure() != null){
            animal.getEnclosure().removeInhabitant(animal);
        }
        inhabitants.add(animal);
        animal.setEnclosure(this);
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
    public static Enclosure createEnclosure(String enclosureType){
        return new Enclosure(enclosureType,enclosureType+" default name");
    }
}
