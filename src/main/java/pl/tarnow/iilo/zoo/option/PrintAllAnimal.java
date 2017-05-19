package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.Helper;
import pl.tarnow.iilo.zoo.MenuOption;
import pl.tarnow.iilo.zoo.Zoo;

import java.util.List;

public class PrintAllAnimal implements MenuOption{

    public String toString(){
        return getOptionName();
    }
    public String getOptionName() {
        return "Who is in zoo?";
    }
    public void execute(Zoo zoo){
        final List<Animal> animalList = zoo.getAnimalList();
        Helper.printList(animalList);
    }

}
