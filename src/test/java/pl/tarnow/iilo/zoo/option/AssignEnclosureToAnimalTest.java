package pl.tarnow.iilo.zoo.option;

import org.junit.Before;
import org.junit.Test;
import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.Enclosure;
import pl.tarnow.iilo.zoo.EnclosureType;
import pl.tarnow.iilo.zoo.Zoo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.*;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AssignEnclosureToAnimalTest {

    private AssignEnclosureToAnimal assignEnclosureToAnimal;
    private Zoo zoo;
    private Scanner scanner;

    @Before
    public void setUp() throws Exception {
        zoo = mock(Zoo.class);

    }

    @Test
    public void executeSuccessfully() throws Exception {
        //given
        scanner = new Scanner("1 1");
        Animal animalMock = mock(Animal.class);
        Enclosure enclosureMock = mock(Enclosure.class);
        Enclosure oldEnclosure = mock(Enclosure.class);

        List<Animal> animals = Arrays.asList(animalMock);
        List<Enclosure> enclosures = Arrays.asList(enclosureMock);

        when(zoo.getAnimalList()).thenReturn(animals);
        when(zoo.getEnclosures()).thenReturn(enclosures);
        when(animalMock.getEnclosure()).thenReturn(oldEnclosure);
        when(animalMock.canLife(enclosureMock)).thenReturn(true);

        assignEnclosureToAnimal = new AssignEnclosureToAnimal(scanner);
        //when
        assignEnclosureToAnimal.execute(zoo);
        //then

        verify(animalMock, times(2)).getEnclosure();
        verify(oldEnclosure,times(1)).removeInhabitant(animalMock);
        verify(animalMock, times(1)).setEnclosure(enclosureMock);
        verify(enclosureMock, times(1)).addInhabitant(animalMock);

    }

    @Test
    public void executeFail() throws Exception {
        scanner = new Scanner("1 1");
        Animal animalMock = mock(Animal.class);
        Enclosure enclosureMock = mock(Enclosure.class);
        Enclosure oldEnclosure = mock(Enclosure.class);

        List<Animal> animals = Arrays.asList(animalMock);
        List<Enclosure> enclosures = Arrays.asList(enclosureMock);

        when(zoo.getAnimalList()).thenReturn(animals);
        when(zoo.getEnclosures()).thenReturn(enclosures);
        when(animalMock.canLife(enclosureMock)).thenReturn(false);
        when(animalMock.getName()).thenReturn("Animal Name");
        when(enclosureMock.getEnclosureType()).thenReturn(EnclosureType.CAGE);

        assignEnclosureToAnimal = new AssignEnclosureToAnimal(scanner);
        //when
        assignEnclosureToAnimal.execute(zoo);
        //then

        verify(animalMock, never()).getEnclosure();
        verify(oldEnclosure,never()).removeInhabitant(animalMock);
        verify(animalMock, never()).setEnclosure(enclosureMock);
        verify(enclosureMock, never()).addInhabitant(animalMock);
    }

}