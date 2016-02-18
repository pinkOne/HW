package ua.di1.supermarket.animal;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by I on 31.01.2016.
 * Factory class to create all the slices of animal part. Animal parts are created from AnimalPart by AnimalParts.
 */
public class AnimalPartSlices {

    public static Collection<AnimalPartSlice> createAnimalPartSlices(AnimalPart animalPart,
                                                                 AnimalPartParameter animalPartParameter) {
        Collection<AnimalPartSlice> animalPartSlices = new ArrayList<>(animalPartParameter.slicesCount);
        int sliceWeight;
        int meetPercent;

        for (int i = 0; i < animalPartParameter.slicesCount; i++) {
            animalPartSlices.add(new AnimalPartSlice(animalPart, animalPartParameter));
        }
        return animalPartSlices;
    }

    public static Bone boneCreator(AnimalPartParameter animalPartParameter) {
        double boneWeight = (double)animalPartParameter.sliceWeight * (100 - animalPartParameter.sliceMeetPercent) / 100;
        return new Bone((int)boneWeight);
    }

    public static Meat meatCreator(AnimalPartParameter animalPartParameter) {
        double meatWeight = (double)animalPartParameter.sliceWeight * animalPartParameter.sliceMeetPercent / 100;
        return new Meat((int)Math.round(meatWeight));
    }
}
