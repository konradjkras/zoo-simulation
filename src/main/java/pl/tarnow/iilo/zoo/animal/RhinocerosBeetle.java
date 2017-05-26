package pl.tarnow.iilo.zoo.animal;

import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.AnimalType;
import pl.tarnow.iilo.zoo.EnclosureType;

public class RhinocerosBeetle extends Animal {
    private String tail;

    public RhinocerosBeetle(String name, int health, String tail) {
        super(name,health);
        this.tail = tail;
    }
     public String toString(){
        return super.toString() + " Look at my tail: "+ tail;
     }
    @Override
    public AnimalType getType() {
        return AnimalType.HERBIVORE;
    }

    @Override

    public EnclosureType supportedEnclosureType(){return EnclosureType.TERRARIUM;}

    public static RhinocerosBeetle createSpecimen(){
        return new RhinocerosBeetle("RhinocerosBeetle Default name", 100 , "Rhino default beautiful tail");
    }

}
