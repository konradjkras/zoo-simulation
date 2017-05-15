package pl.tarnow.iilo.zoo;


import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private String enclosureType;
    private String description;
    private List<Animal> inhibitants;

    public String getEnclosureType() {
        return enclosureType;
    }

    public String getDescription() {
        return description;
    }


    public Enclosure(String enclosureType, List<Animal> inhibitants, String description) {
        this.enclosureType = enclosureType;
        this.description = description;
        inhibitants = new ArrayList<>();
    }
    public String toString



}
