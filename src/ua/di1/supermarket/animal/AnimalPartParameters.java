package ua.di1.supermarket.animal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by I on 01/02/2016.
 * Static factory class that creates all the parameters
 */
public class AnimalPartParameters { // factory for creating animal part parameters
    public static Collection<AnimalPartParameter> createAnimalPartParameters(){
        Collection<AnimalPartParameter> animalPartParameters = new ArrayList<>();
        animalPartParameters.add(new AnimalPartParameter("Head", 2, 1500, 10));
        animalPartParameters.add(new AnimalPartParameter("Neck", 2, 1000, 90));
        animalPartParameters.add(new AnimalPartParameter("Shoulder", 8, 1000, 90));
        animalPartParameters.add(new AnimalPartParameter("Rack", 8, 1000, 50));
        animalPartParameters.add(new AnimalPartParameter("Loin", 12, 1000, 70));
        animalPartParameters.add(new AnimalPartParameter("Sirloin", 6, 900, 90));
        animalPartParameters.add(new AnimalPartParameter("Leg", 8, 1000, 95));
        animalPartParameters.add(new AnimalPartParameter("Foreshank", 4, 1000, 40));
        animalPartParameters.add(new AnimalPartParameter("Breast", 4, 1000, 95));
        animalPartParameters.add(new AnimalPartParameter("Flank", 2, 1200, 100));
        animalPartParameters.add(new AnimalPartParameter("Hindshank", 4, 1000, 55));
        animalPartParameters.add(new AnimalPartParameter("Feet(trotters)", 8, 300, 20));
        return animalPartParameters;
    }
}
/*
        Head	2	1500	10
        Neck	2	1000	90
        Shoulder	8	1000	90
        Rack	8	1000	50
        Loin	12	1000	70
        Sirloin	6	900	90
        Leg	8	1000	95
        Foreshank	4	1000	40
        Breast	4	1000	95
        Flank	2	1200	100
        Hindshank	4	1000	55
        Feet(trotters)	8	300	20
        ==63200
*/
