package pl.tarnow.iilo.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private String name;
    private List<Animal> animalList;
    private List<Enclosure> enclosureList;

    public Zoo(String name){
        this.name = name;
        animalList = new ArrayList<>();
        enclosureList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Animal> getAnimalList() {
        return animalList;
    }

    public void addAnimal(Animal animal){
        animalList.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animalList.remove(animal);
        final Enclosure enclosure = animal.getEnclosure();
        enclosure.removeInhabitant(animal);
    }

    public void addEnclosure(Enclosure enclosure){
        enclosureList.add(enclosure);
    }

    public List<Enclosure> getEnclosures() {
        return enclosureList;
    }
}
