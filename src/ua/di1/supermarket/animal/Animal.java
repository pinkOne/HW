package ua.di1.supermarket.animal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by I on 30.01.2016.
 * Animal class represents a animal split on body parts and slices.
 */
public class Animal extends BodyPart {
    private int ID;
    private Date birthDate;
    private Date killDate;

    private ArrayList<AnimalPart> animalParts;



    public Animal(String name, String description, int ID, Date birthDate) {
        this(name, ID, birthDate);
        this.description = description;
    }
    public Animal(String name, int ID, Date birthDate) {
        this(ID, birthDate);
        this.name = name;
    }

    public boolean setKillDate(Date killDate) {
        if (killDate.before(getBirthDate())) return false;
        this.killDate = killDate;
        return true;
    }

    public Animal(int ID, Date birthDate) {
        this.ID = ID;
        this.birthDate = birthDate;

        animalParts = (ArrayList<AnimalPart>) AnimalParts.createAllAnimalParts(this);
        for (AnimalPart animalPart : animalParts) {
            weight += animalPart.getWeight();
        }
    }

    public int getID() {
        return ID;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public Date getKillDate() {
        return killDate;
    }

    public ArrayList<AnimalPart> getAnimalParts() {
        return animalParts;
    }

    @Override
    public int getWeight() {
        return weight;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        String animalStringView = "Animal %s (ID:%d)\nDescription: %s\nAge: %s months, weight: %d\n\tAnimal Parts:";
        for (AnimalPart animalPart : animalParts) {
            animalStringView += ("\n\t\t" + animalPart.toString());
        }
        return String.format(animalStringView, getName(), getID(), getDescription(), getAge(), getWeight());
    }

    public int getAge() { // in months
        int age;
        Calendar birth = Calendar.getInstance();
        Calendar kill = Calendar.getInstance();
        birth.setTime(birthDate);
        kill.setTime((killDate == null)? Calendar.getInstance().getTime() : killDate);
        int years = kill.get(Calendar.YEAR) - birth.get(Calendar.YEAR);
        age = years * 12 + kill.get(Calendar.MONTH) - birth.get(Calendar.MONTH);
        return age;
    }
}
