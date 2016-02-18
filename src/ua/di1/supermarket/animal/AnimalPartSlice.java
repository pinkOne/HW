package ua.di1.supermarket.animal;

/**
 * Created by I on 30.01.2016.
 * Class represents a slice of body part that consists of meat and bones.
 */
public class AnimalPartSlice extends BodyPart{
    private Meat meat;
    private Bone bone;
    private AnimalPart animalPart;

    public AnimalPartSlice(AnimalPart animalPart, AnimalPartParameter animalPartParameter) {
        this.animalPart = animalPart;
        this.meat = AnimalPartSlices.meatCreator(animalPartParameter);
        this.bone = AnimalPartSlices.boneCreator(animalPartParameter);

        weight = meat.getWeight() + bone.getWeight();
    }

    @Override
    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        String animalPartSliceStringView = "Slice: meat: %d, bone: %d";
        return String.format(animalPartSliceStringView, meat.getWeight(), bone.getWeight());
    }
}
