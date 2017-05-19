package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.*;

import java.util.List;
import java.util.Scanner;

public class AssignEnclosuresToAnimal implements MenuOption{
    private Scanner scanner;

    public AssignEnclosuresToAnimal(){
        this.scanner = new Scanner(System.in);
    }

    public String toString(){
        return getOptionName();
    }
    public String getOptionName() {
        return "Assign enclosures to animal";
    }
    public void execute(Zoo zoo){
        final List<Animal> animalList = zoo.getAnimalList();
        Helper.printList(animalList);
        final int animalChoice = scanner.nextInt();
        final List<Enclosure> enclosuresList = zoo.getEnclosures();
        Helper.printList(enclosuresList);
        final int enclosureChoice=scanner.nextInt();
        enclosuresList.get(enclosureChoice-1).addInhabitant(animalList.get(animalChoice-1));

    }
}
