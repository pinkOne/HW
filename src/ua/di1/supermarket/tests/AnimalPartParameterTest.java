package ua.di1.supermarket.tests;

import org.junit.Test;
import ua.di1.supermarket.animal.AnimalPartParameter;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartParameterTest {

    @Test
    public void testAnimalPartParameter() throws Exception {
        checkResult("AnimalPartParameterTest.AnimalPartParameter",
                new AnimalPartParameter("Head", 2, 1500, 2).getName().equals("Head"));
    }

}