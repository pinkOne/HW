package ua.di1.supermarket.animal;

/**
 * Created by I on 30.01.2016.
 * Abstract class for any body part
 */
public abstract class BodyPart {
    protected String name;
    protected String description;
    protected int weight;

    public abstract int getWeight();

    public String getName() {
        return name;
    }
}
