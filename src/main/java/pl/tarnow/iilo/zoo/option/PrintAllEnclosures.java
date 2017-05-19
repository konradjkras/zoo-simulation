package pl.tarnow.iilo.zoo.option;


import pl.tarnow.iilo.zoo.*;

import java.util.List;

public class PrintAllEnclosures implements MenuOption {
    public String toString(){
        return getOptionName();
    }
    public String getOptionName() {
        return "Enlosures list";
    }
    public void execute(Zoo zoo){
        final List<Enclosure> enclosuresList = zoo.getEnclosures();
        Helper.printList(enclosuresList);
    }
}
