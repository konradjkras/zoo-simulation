package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.*;

import java.util.List;
import java.util.Scanner;

public class PrintAnimalsInEnclosures implements MenuOption {
    private Scanner scanner;
    private List<Animal>inhabitants;

    public PrintAnimalsInEnclosures() {
        this.scanner = new Scanner(System.in);
    }
    public String toString(){
        return getOptionName();
    }
    public String getOptionName() {
        return "Who is in particular enclosures?";
    }
    public void execute(Zoo zoo){
        final List<Enclosure>enclosuresList=zoo.getEnclosures();
        Helper.printList(enclosuresList);
        final int enclosuresChoice=scanner.nextInt();
        for(Animal animal: enclosuresList.get(enclosuresChoice-1).getInhabitants()){
            System.out.println(animal.toString());
        }


    }
}
