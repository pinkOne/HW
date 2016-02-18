package ua.di1.supermarket.tests;

import org.junit.Test;
import ua.di1.supermarket.animal.AnimalPartParameter;
import ua.di1.supermarket.animal.AnimalPartParameters;

import java.util.Collection;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartParametersTest {

    @Test
    public void testCreateAnimalPartParameters() throws Exception {
        Collection<AnimalPartParameter> animalPartParameters = AnimalPartParameters.createAnimalPartParameters();
        checkResult("AnimalPartParametersTest.testCreateAnimalPartParameters.size", animalPartParameters.size() == 12);
    }
}