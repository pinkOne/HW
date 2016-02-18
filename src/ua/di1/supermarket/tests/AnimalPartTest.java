package ua.di1.supermarket.tests;

import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.AnimalPart;
import ua.di1.supermarket.animal.AnimalPartParameter;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartTest {

    AnimalPart animalPart;

    @Before
    public void setUp() throws Exception {
        animalPart = new AnimalPart(new AnimalPartParameter("ChuwieYoga", 5, 56, 98), null);
        animalPart.setDescription("Juicy part ready for steaks etc.");
    }

    @Test
    public void testGetWeight() throws Exception {
        checkResult("AnimalPartTest.testGetWeight", animalPart.getWeight() == 280);
    }

    @Test
    public void testGetDescription() throws Exception {
        checkResult("AnimalPartTest.testGetDescription", animalPart.getDescription().contains("Juicy"));
    }

    @Test
    public void testToString() throws Exception {
        checkResult("AnimalPartTest.testToString", animalPart.toString().contains("280"));
    }
}