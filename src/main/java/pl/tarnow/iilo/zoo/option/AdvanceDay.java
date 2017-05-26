package pl.tarnow.iilo.zoo.option;

import pl.tarnow.iilo.zoo.MenuOption;
import pl.tarnow.iilo.zoo.Simulation;
import pl.tarnow.iilo.zoo.Zoo;

public class AdvanceDay  implements MenuOption{
    private Simulation simulation;


    public AdvanceDay(Simulation simulation) {
        this.simulation = simulation;
    }

    @Override
    public String getOptionName() {
        return "Advance day";
    }

    @Override
    public void execute(Zoo zoo) {
        System.out.println("Next day is coming!");
        simulation.advanceDay();
    }

    @Override
    public String toString(){
        return getOptionName();
    }
}
