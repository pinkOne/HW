package ua.di1.supermarket.tests;

import org.junit.Test;
import ua.di1.supermarket.animal.AnimalPart;
import ua.di1.supermarket.animal.AnimalParts;

import java.util.Collection;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartsTest {


    @Test
    public void testAnimalParts() throws Exception {
        Collection<AnimalPart> animalParts = AnimalParts.createAllAnimalParts(null);
        System.out.println(String.format("animalParts = %s ..., count: %d",
                                            animalParts.iterator().next().getName(),
                                            animalParts.size()));
        checkResult("AnimalPartsTest.testAnimalParts", animalParts.size() > 0);
    }
}