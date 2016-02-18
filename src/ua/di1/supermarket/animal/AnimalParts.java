package ua.di1.supermarket.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by I on 31.01.2016.
 * Static factory for AnimalPart creation using AnimalPartParameters
 */
public class AnimalParts {

    public static Collection<AnimalPart> createAllAnimalParts(Animal animal) {
        ArrayList<AnimalPartParameter> animalPartParameters = (ArrayList<AnimalPartParameter>) AnimalPartParameters.createAnimalPartParameters();

        Collection<AnimalPart> animalParts = new ArrayList<>();
        for (AnimalPartParameter animalPartParameter : animalPartParameters) {
            animalParts.add(new AnimalPart(animalPartParameter, animal));
        }
        return animalParts;
    }

}
