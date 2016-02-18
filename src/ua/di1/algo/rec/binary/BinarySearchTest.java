package ua.di1.algo.rec.binary;

import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;
import static ua.di1.Test.checkResult;

/**
 * Created by I on 2016-02-13.
 *
 */
public class BinarySearchTest {
    int[] mas;
    @Before
    public void setUp() throws Exception {
        mas = new int[]{1,2,3,4,5,6,7,8,9};
    }

    @Test
    public void testFind() throws Exception {
        int result = BinarySearch.find(mas, 6);
        checkResult("testFind", result == 5);
    }
}