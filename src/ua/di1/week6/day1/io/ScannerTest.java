package ua.di1.week6.day1.io;

import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;
import ua.di1.week6.day1.io.Scanner;

import static org.junit.Assert.*;
import static ua.di1.Test.checkResult;

/**
 * Created by I on 2016-02-25.
 */
public class ScannerTest {
    Scanner scanner;
    Reader reader;
    String buffer = "Ще не вм 3 рла України, н1 слава, ні в0л9,\nЩе нам, браття-українці, усміхнеться доля. 111";

    @Before
    public void setUp() throws Exception {
        reader = new CharArrayReader(buffer.toCharArray());
        scanner = new Scanner(reader);
    }

    @Test
    public void testUseDelimiter() throws Exception {
        char oldDelimiter = scanner.getDelimiter();
        scanner.useDelimiter('|');
        char newDelimiter = scanner.getDelimiter();;
        checkResult("testUseDelimiter", oldDelimiter != newDelimiter);
    }

    @Test
    public void testNextInt() throws Exception {
        int oldData = 3;
        String tmp;
        tmp = scanner.next();
        tmp = scanner.next();
        tmp = scanner.next();
        int newData = scanner.nextInt();
        checkResult("testNextInt", oldData == newData);
    }

    @Test
    public void testNext() throws Exception {
        String oldData = "Ще";
        String newData = scanner.next();
        checkResult("testNext", oldData.equals(newData));
    }

    @Test
    public void testNextLine() throws Exception {
        String oldData = "Ще не вм 3 рла України, н1 слава, ні в0л9,";
        String newData = scanner.nextLine();
        checkResult("testNextLine", oldData.equals(newData));
    }

    @Test
    public void testHasNext() throws Exception {
        checkResult("testHasNext", scanner.hasNext());
    }

    @Test
    public void testHasNextInt() throws Exception {
        scanner.next();
        scanner.next();
        scanner.next();
        checkResult("testHasNext", scanner.hasNextInt());
    }
}