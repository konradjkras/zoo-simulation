package pl.tarnow.iilo.zoo;

import java.util.List;

public class Menu {
    private Zoo zoo;
    private List<MenuOption> optionList;

    public Menu(Zoo zoo, List<MenuOption> optionList) {
        this.zoo = zoo;
        this.optionList = optionList;
    }

    public void printMenu(){
        Helper.printList(optionList);
    }

    public void executeAction(int choice) throws OptionFailedException {
        if(choice> optionList.size()){
            throw new OptionFailedException("Unrecognized option");
        }
        optionList.get(choice-1).execute(zoo);
    }

}
