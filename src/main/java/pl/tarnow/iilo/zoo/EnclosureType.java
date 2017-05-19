package pl.tarnow.iilo.zoo;


public enum EnclosureType {
    TERRARIUM, PADDOCK, CAGE;
    @Override
    public String toString() {
        return super.toString().toLowerCase();
    }
}
