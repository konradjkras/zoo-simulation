package pl.tarnow.iilo.zoo;

import pl.tarnow.iilo.zoo.animal.Alpaca;
import pl.tarnow.iilo.zoo.animal.Cat;
import pl.tarnow.iilo.zoo.animal.RhinocerosBeetle;
import pl.tarnow.iilo.zoo.option.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {

    private static Zoo zoo;
    private static Simulation simulation;
    private static List<MenuOption> optionList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        initializeZoo();
        simulation = new Simulation(zoo);
        initializeOptions();

        Menu menu = new Menu(zoo, optionList);

        System.out.println("At the begining of the simulation in zoo \"" + zoo.getName() +"\" inventory is:");
        printAllAnimalsInZoo();

        for(int i=0; i<105; i++){
            System.out.println("__________________________");
            menu.printMenu();
            final int choice = scanner.nextInt();
            menu.executeAction(choice);
            //printAllAnimalsInZoo();
        }

        System.out.println("At the end of the simulation in zoo" + zoo.getName() +" inventory is:");
        printAllAnimalsInZoo();

    }

    private static void initializeOptions() {
        Scanner scanner = new Scanner(System.in);
        optionList = new ArrayList<MenuOption>();
        optionList.add(new FeedAnimal());
        optionList.add(new BuyAnimal());
        optionList.add(new CreateEnclosure());
        optionList.add(new ChangeAnimalName());
        optionList.add(new ChangeEnclosureName());
        optionList.add(new PrintAllAnimal());
        optionList.add(new PrintAllEnclosures());
        optionList.add(new PrintAnimalsInEnclosures());
        optionList.add(new AssignEnclosureToAnimal(scanner));
        optionList.add(new AdvanceDay(simulation));
    }

    private static void printAllAnimalsInZoo() {
        for(Animal animal : zoo.getAnimalList()){
            System.out.println(animal);
        }
    }

    private static void initializeZoo() {
        Cat catMaciek = new Cat("Maciek", 100);
        RhinocerosBeetle rhinoStephen = new RhinocerosBeetle("Stephen", 100,"My tail is amazing");
        Alpaca alpacaCate = new Alpaca("Cate", 10);
        Enclosure stephanTerrarium = new Enclosure(EnclosureType.TERRARIUM, "Sephans Terrarium");
        Enclosure maciekPaddock = new Enclosure(EnclosureType.PADDOCK, "Maciek's Padddock");
        stephanTerrarium.addInhabitant(rhinoStephen);
        maciekPaddock.addInhabitant(catMaciek);
        zoo = new Zoo("My zoo");
        zoo.addAnimal(catMaciek);
        zoo.addAnimal(rhinoStephen);
        zoo.addAnimal(alpacaCate);
        zoo.addEnclosure(stephanTerrarium);
        zoo.addEnclosure(maciekPaddock);

        simulation = new Simulation(zoo);    }
}
