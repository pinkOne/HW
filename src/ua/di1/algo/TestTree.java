package ua.di1.algo;

import java.util.Arrays;

/**
 * Created by serhii on 07.02.16.
 */
public class TestTree {

    public static void main(String[] args) {
        Link emp1 = new Link(1, "eml1");
        Link emp2 = new Link(1, "eml2");

        Link emp3 = new Link(1, "eml3");
        Link emp4 = new Link(1, "eml4");

        Link emp5 = new Link(1, "eml5");
        Link emp6 = new Link(1, "eml6");

        Link manag1 = new Link(2,"man1");
        manag1.addChild(emp1);
        manag1.addChild(emp2);

        Link manag2 = new Link(2,"man2");
        manag2.setChildren(Arrays.asList(emp3,emp4));

        Link manag3 = new Link(2,"man3", emp5,emp6);

        Link manag4 = new Link(2,"man4");


        Link dir1 = new Link(4,"dir1", manag1,manag2,manag3,manag4);

        dir1.report();
        dir1.getAmount(manag3);
    }
}
