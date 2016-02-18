package ua.di1.supermarket.animal;

import java.util.ArrayList;

/**
 * Created by I on 30.01.2016.
 *
 */
public class AnimalPart extends BodyPart {
    private ArrayList<AnimalPartSlice> animalPartSlices;
    private Animal animal;

    public AnimalPart(AnimalPartParameter animalPartParameter, Animal animal) {
        this.name = animalPartParameter.name;
        this.animal = animal;
        animalPartSlices = (ArrayList<AnimalPartSlice>) AnimalPartSlices.createAnimalPartSlices(this, animalPartParameter);
        for (AnimalPartSlice animalPartSlice : animalPartSlices) {
            weight += animalPartSlice.getWeight();
        }
    }


    @Override
    public int getWeight() {
        return weight;
    }

    public boolean setDescription(String description) {
        this.description = description;
        return true;
    }

    public String getDescription() {
        return (description == null)? "" : description;
    }

    @Override
    public String toString() {
        String animalPartStringView = "AnimalPart: %s, description: %s, weight: %d, Slices:";
        for (AnimalPartSlice animalPartSlice : animalPartSlices) {
            animalPartStringView += ("\n\t\t\t" + animalPartSlice.toString());
        }
        return String.format(animalPartStringView, getName(), getDescription(), getWeight());
    }
}
