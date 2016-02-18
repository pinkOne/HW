package ua.di1.supermarket.animal;

/**
 * Created by I on 30.01.2016.
 * Bone class represents net weight of bones in body part.
 */
public class Bone extends BodyPart {

    public Bone(int weight) {
        this.weight = weight;
    }

    @Override
    public int getWeight() {
        return weight;
    }
}
