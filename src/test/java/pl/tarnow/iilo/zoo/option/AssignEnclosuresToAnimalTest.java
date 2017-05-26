package pl.tarnow.iilo.zoo.option;

import org.junit.Before;
import org.junit.Test;
import pl.tarnow.iilo.zoo.Animal;
import pl.tarnow.iilo.zoo.Enclosure;
import pl.tarnow.iilo.zoo.Zoo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.internal.verification.VerificationModeFactory.times;

public class AssignEnclosuresToAnimalTest {

    private AssignEnclosuresToAnimal assignEnclosuresToAnimal;
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

        assignEnclosuresToAnimal = new AssignEnclosuresToAnimal(scanner);
        //when
        assignEnclosuresToAnimal.execute(zoo);
        //then

        verify(animalMock, times(1)).getEnclosure();
        verify(oldEnclosure,times(1)).removeInhabitant(animalMock);
        verify(animalMock, times(1)).setEnclosure(enclosureMock);
        verify(enclosureMock, times(1)).addInhabitant(animalMock);

    }

    @Test
    public void executeFail() throws Exception {

    }

}