package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.*;

import java.util.List;
import java.util.Scanner;

public class AssignEnclosureToAnimal implements MenuOption{
    private Scanner scanner;

    public AssignEnclosureToAnimal(Scanner scanner){
        this.scanner = scanner;
    }

    public String toString(){
        return getOptionName();
    }

    public String getOptionName() {
        return "Assign enclosures to animal";
    }

    public void execute(Zoo zoo){
        final Animal chosenAnimal = chooseAnimal(zoo);
        final Enclosure chosenEnclosure = chooseEnclosure(zoo);

        if(chosenAnimal.canLife(chosenEnclosure)) {
            if(chosenAnimal.getEnclosure() != null){
                chosenAnimal.getEnclosure().removeInhabitant(chosenAnimal);
            }
            chosenEnclosure.addInhabitant(chosenAnimal);
            chosenAnimal.setEnclosure(chosenEnclosure);
        } else {
            System.out.println(chosenAnimal.getName()+" can't be in "
                    + chosenEnclosure.getEnclosureType().toString());
        }
    }

    private Enclosure chooseEnclosure(Zoo zoo) {
        final List<Enclosure> enclosuresList = zoo.getEnclosures();
        Helper.printList(enclosuresList);
        final int enclosureChoice=scanner.nextInt();
        return enclosuresList.get(enclosureChoice - 1);
    }

    private Animal chooseAnimal(Zoo zoo) {
        final List<Animal> animalList = zoo.getAnimalList();
        Helper.printList(animalList);
        final int animalChoice = scanner.nextInt();
        return animalList.get(animalChoice - 1);
    }
}
