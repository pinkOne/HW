package ua.di1.supermarket.animal;

/**
 * Created by I on 02/02/2016.
 * class holding the data for animal parts
 */
public class AnimalPartParameter {
    protected String name;
    protected int slicesCount;
    protected int sliceWeight;
    protected int sliceMeetPercent;

    public AnimalPartParameter(String name, int slicesCount,
                               int sliceWeight, int sliceMeetPercent) {
        this.name = name;
        this.slicesCount = slicesCount;
        this.sliceWeight = sliceWeight;
        this.sliceMeetPercent = sliceMeetPercent;
    }

    public String getName() {
        return name;
    }
}
