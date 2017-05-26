package pl.tarnow.iilo.zoo.option;

import org.junit.Test;
import org.mockito.Mockito;
import pl.tarnow.iilo.zoo.Simulation;
import pl.tarnow.iilo.zoo.Zoo;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import static com.sun.javaws.JnlpxArgs.verify;


public class AdvanceDayTest {
    @Test
    public void execute() throws Exception {
        //given
        Zoo ignored=null;
        Simulation simulation= mock(Simulation.class);
        AdvanceDay advanceDay=new AdvanceDay(simulation);

        //when
        advanceDay.execute(ignored);


        //then
       Mockito.verify(simulation, times(1)).advanceDay();
    }

}