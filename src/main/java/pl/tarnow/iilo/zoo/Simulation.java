package pl.tarnow.iilo.zoo;

import java.util.ArrayList;
import java.util.List;

public class Simulation {
    private Zoo zoo;

    public Simulation(Zoo zoo) {
        this.zoo = zoo;
    }

    public void advanceDay(){
        checkForStarvation();
        checkForCanibalism();
    }

    private void checkForCanibalism() {
        final List<Enclosure> enclosures = zoo.getEnclosures();
        for(Enclosure enclosure: enclosures){
            if(enclosureConainsCarnivore(enclosure)){
                killRandomHerbivore(enclosure);
            }
        }
    }

    private void killRandomHerbivore(Enclosure enclosure) {
        for(Animal animal: enclosure.getInhabitants()){
            if(animal.getType()== AnimalType.HERBIVORE){
                System.out.println("AAAA I am " + animal.getName() +" and I am beeing eaten!!!");
                zoo.removeAnimal(animal);
                return;
            }
        }
    }

    private boolean enclosureConainsCarnivore(Enclosure enclosure) {
        for(Animal animal: enclosure.getInhabitants()){
            if(animal.getType() == AnimalType.CARNIVORE)
                return true;
        }
        return false;
    }

    private void checkForStarvation() {
        List<Animal> deadAnimals = new ArrayList();
        for (Animal animal: zoo.getAnimalList()){
            animal.advanceDay();
            if(!animal.isAlive()){
                deadAnimals.add(animal);
            }
        }
        for(Animal animal: deadAnimals) {
            System.out.println("WARNING!! \t" + animal.getName() + "\t IS DEAD!!");
            zoo.removeAnimal(animal);
        }
    }
}
