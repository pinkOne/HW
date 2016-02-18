package ua.di1.supermarket.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.Meat;

import static org.junit.Assert.*;
import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class MeatTest {
    Meat meat;
    int testWeight = 1250;

    @Before
    public void setUp() throws Exception {
        meat = new Meat(testWeight);
        meat.getName();
    }

    @Test
    public void testGetWeight() throws Exception {
        checkResult("MeatTest.testGetWeight", meat.getWeight() ==  testWeight);
    }
}