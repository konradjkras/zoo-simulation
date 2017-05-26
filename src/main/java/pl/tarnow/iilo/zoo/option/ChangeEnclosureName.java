package pl.tarnow.iilo.zoo.option;

import pl.tarnow.iilo.zoo.*;

import java.util.List;
import java.util.Scanner;

public class ChangeEnclosureName implements MenuOption {
    private Scanner scanner;

    public ChangeEnclosureName() {this.scanner=new Scanner(System.in);
    }
    public String toString(){
        return getOptionName();
    }

    public String getOptionName() {
        return "Change enclosure's description";
    }
    public void execute(Zoo zoo) {
        System.out.println("Pick enclosure");
        final List<Enclosure> enclosureList = zoo.getEnclosures();

        Helper.printList(enclosureList);
        final int enclosureChoice = scanner.nextInt();

        System.out.println("Give new description");

        final Scanner input= new Scanner(System.in);
        String newName=input.nextLine();
        enclosureList.get(enclosureChoice-1).changeDescription(newName);
    }
}
