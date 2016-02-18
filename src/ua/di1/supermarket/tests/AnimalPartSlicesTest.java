package ua.di1.supermarket.tests;

import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.*;

import java.util.Collection;

import static org.junit.Assert.*;
import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalPartSlicesTest {

    @Test
    public void testCreateAnimalPartSlices() throws Exception {
        Collection<AnimalPartSlice> animalPartSlices =
                AnimalPartSlices.createAnimalPartSlices(null, new AnimalPartParameter("Head", 2, 1500, 15));
        checkResult("AnimalPartSlicesTest.testCreateAnimalPartSlices.size", animalPartSlices.size() == 2);
        checkResult("AnimalPartSlicesTest.testCreateAnimalPartSlices.getWeight",
                animalPartSlices.iterator().next().getWeight() == 1500);
    }

    @Test
    public void testBoneCreator() throws Exception {
        Bone bone = AnimalPartSlices.boneCreator(new AnimalPartParameter("neck", 5, 100, 10));
        checkResult("AnimalPartSlicesTest.testBoneCreator", bone.getWeight() == 90);
    }

    @Test
    public void testMeatCreator() throws Exception {
        Meat meat = AnimalPartSlices.meatCreator(new AnimalPartParameter("neck", 5, 100, 10));
        checkResult("AnimalPartSlicesTest.testBoneCreator", meat.getWeight() == 10);
    }
}