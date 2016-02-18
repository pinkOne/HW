package ua.di1.supermarket.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.Bone;

import static org.junit.Assert.*;
import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class BoneTest {
    Bone bone;
    int testWeight = 250;

    @Before
    public void setUp() throws Exception {
        bone = new Bone(testWeight);
        bone.getName();
    }

    @Test
    public void testGetWeight() throws Exception {
        checkResult("BoneTest.testGetWeight", bone.getWeight() ==  testWeight);
    }
}