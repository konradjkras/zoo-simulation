package pl.tarnow.iilo.zoo;

public abstract class Animal {
    private int health;
    private String name;
    private Enclosure enclosure;

    public Animal(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public String getName(){
        return name;
    }

    public int getHealth() {
        return health;
    }

    abstract public EnclosureType supportedEnclosureType();

    public String toString(){
        return "Name: " +  name + " I am "+ getType() + ", HP: " + health;
    }

    public void advanceDay(){
        health--;
    }

    public boolean isAlive(){
        return health>0;
    }
    public boolean isMissing(){return enclosure==null;}

    public void feed(){
        health+=10;
        System.out.println("Hi here is " +  name + " I just got fed");
    }
    public void changeName(String newName){
        System.out.println("Hi here is "+name+" My new name is: "+newName);
        this.name=newName;

    }

    public void setEnclosure(Enclosure enclosure) {
        this.enclosure = enclosure;

    }

    abstract public AnimalType getType();

    public Enclosure getEnclosure() {
        return enclosure;
    }

}
