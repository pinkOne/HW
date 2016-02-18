package ua.di1.supermarket.animal;

/**
 * Created by I on 30.01.2016.
 * Meat class represents net weight of meat in body part.
 */
public class Meat extends BodyPart {

    public Meat(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
