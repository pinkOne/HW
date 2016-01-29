package ua.di1;

/**
 * Created by I on 26.01.2016.
 */
public class Test {

    public static void checkResult(String testName, boolean passed){
        String message = ((passed) ? "Passed\t" : "NOT PASSED") + "\t" + testName ;
        System.out.println(message);
    }

    public static void main(String[] args) {
        Test.checkResult("checkResult", true);
    }
}
