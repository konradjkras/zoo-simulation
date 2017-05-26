package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.*;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CreateEnclosure implements MenuOption{

    private Scanner scanner;

    public CreateEnclosure() {
        this.scanner = new Scanner(System.in);
    }
    public String toString(){
        return getOptionName();
    }
    public String getOptionName() {
        return "Buy an enclosure";
    }
    public void execute(Zoo zoo){
        System.out.println("Choose what kind of enclosure you want to buy: ");
        for (int i=0;i<EnclosureType.values().length;i++) {
            System.out.println((i+1) + ". " + EnclosureType.values()[i].toString());
        }
        final int enclosuresTypeChoice=scanner.nextInt();
        Enclosure newEnclosure= Enclosure.createEnclosure(EnclosureType.values()[enclosuresTypeChoice-1]);
        System.out.println("Give a decription of this enclosure");
        Scanner input=new Scanner(System.in);
        String description=input.nextLine();
        newEnclosure.changeDescription(description);
        zoo.addEnclosure(newEnclosure);
        System.out.println("You have just bought a new enclosure ("+EnclosureType.values()[enclosuresTypeChoice-1].toString()+")");
    }
}
