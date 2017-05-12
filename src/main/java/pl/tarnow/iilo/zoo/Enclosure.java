package pl.tarnow.iilo.zoo;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String enclosureType;
    private String description;
    private List<Animal> inhabitants;

    public Enclosure(String enclosureType, String description) {
        this.enclosureType = enclosureType;
        this.description = description;
        inhabitants = new ArrayList<>();
    }

    public String getEnclosureType() {
        return enclosureType;
    }


    public String getDescription() {
        return description;
    }

    public void addInhabitant(Animal animal){
        inhabitants.add(animal);
        animal.setEnclosure(this);
    }

    @Override
    public String toString() {
        return getDescription();
    }
}
