package pl.tarnow.iilo.zoo.animal;

import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.AnimalType;
import pl.tarnow.iilo.zoo.EnclosureType;

public class Alpaca extends Animal {

    public Alpaca(String name, int health) {
        super(name, health);
    }
    public EnclosureType supportedEnclosureType(){return EnclosureType.PADDOCK;}
    @Override
    public AnimalType getType() {
        return AnimalType.HERBIVORE;
    }

    public static Alpaca createSpecimen(){
        return new Alpaca("Alpaca Default name", 100);
    }
}
