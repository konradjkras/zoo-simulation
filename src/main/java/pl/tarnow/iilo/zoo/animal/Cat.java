package pl.tarnow.iilo.zoo.animal;

import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.AnimalType;

public class Cat extends Animal {

    public Cat(String name, int health) {
        super(name, health);
    }

    @Override
    public AnimalType getType() {
        return AnimalType.CARNIVORE;
    }


    public static Cat createSpecimen(){
        return new Cat("Cat Default name", 100);
    }
}
