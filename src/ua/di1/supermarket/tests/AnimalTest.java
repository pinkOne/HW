package ua.di1.supermarket.tests;

import org.junit.Before;
import org.junit.Test;
import ua.di1.supermarket.animal.Animal;

import java.util.Calendar;
import java.util.Date;

import static ua.di1.Test.checkResult;

/**
 * Created by I on 03/02/2016.
 *
 */
public class AnimalTest {

    Animal animal;

    public static Animal createAnimal(){
        Calendar calendar =  Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2015);
        calendar.set(Calendar.MONTH, Calendar.APRIL);
        Date birthDay = calendar.getTime();
        return new Animal("Shaun", "Nice pall, fat a bit.", 1, birthDay);
    }

    @Before
    public void setUp() throws Exception {
        animal = createAnimal();
    }

    @Test
    public void testGetID() throws Exception {
        checkResult("AnimalTest.testGetID", animal.getID() == 1);
    }

    @Test
    public void testGetBirthDate() throws Exception {
        String birthDateString = animal.getBirthDate().toString();
        System.out.println("birthDateString = " + birthDateString);
        checkResult("AnimalTest.testGetBirthDate", birthDateString.contains("Apr"));
    }

    @Test
    public void testGetKillDate() throws Exception {
        Calendar killDate = Calendar.getInstance();
        killDate.set(2015,Calendar.FEBRUARY,4);
        checkResult("AnimalTest.setKillDate", ! animal.setKillDate(killDate.getTime()));
        //Assert.assertFalse(animal.setKillDate(killDate.getTime()));

        killDate.set(2015,Calendar.AUGUST,4);
        animal.setKillDate(killDate.getTime());
        String killDateString = animal.getKillDate().toString();
        System.out.println("killDateString = " + killDateString);
        checkResult("AnimalTest.testGetKillDate", killDateString.contains("Aug"));
    }

    @Test
    public void testGetAnimalParts() throws Exception {
        checkResult("AnimalTest.testGetAnimalParts", animal.getAnimalParts().size() == 12);
    }

    @Test
    public void testGetWeight() throws Exception {
        checkResult("AnimalTest.testGetWeight", animal.getWeight() == 63200);
    }

    @Test
    public void testGetDescription() throws Exception {
        checkResult("AnimalTest.getDescription", animal.getDescription().contains("pall") );
    }

    @Test
    public void testToString() throws Exception {
        String animalStringView = animal.toString();
        System.out.println(animalStringView);
        checkResult("testAnimal.toString", animalStringView.contains("pall"));
    }

    @Test
    public void testGetAge() throws Exception {
        Calendar killDate = Calendar.getInstance();
        killDate.set(2016,Calendar.FEBRUARY,3);
        checkResult("testAnimal.getAge", animal.setKillDate(killDate.getTime()) && (animal.getAge() == 10));
    }
}