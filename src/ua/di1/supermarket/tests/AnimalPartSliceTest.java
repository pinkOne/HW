package ua.di1.supermarket.tests;

import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.AnimalPartParameter;
import ua.di1.supermarket.animal.AnimalPartSlice;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartSliceTest {

    AnimalPartSlice animalPartSlice;

    @Before
    public void setUp() throws Exception {
        animalPartSlice = new AnimalPartSlice(null, new AnimalPartParameter("WookieHead", 3, 1200, 30));
    }

    @Test
    public void testGetWeight() throws Exception {
        checkResult("AnimalPartSlice.testGetWeight", animalPartSlice.getWeight() == 1200);
    }

    @Test
    public void testToString() throws Exception {
        String testToString = animalPartSlice.toString();
        System.out.println("testToString = " + testToString);
        checkResult("AnimalPartSlice.testToString", testToString.contains("Slice: meat"));
    }
}