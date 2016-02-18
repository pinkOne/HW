package ua.di1.supermarket.bar;

import ua.di1.supermarket.Location;

import java.util.List;

/**
 * Created by I on 2016-02-17.
 * Class that represents supermarket table.
 */
public class Bar {
    private String name;
    private Location location;
    private List<BarItem> items;

    public Bar(String name, Location location) {
        this.name = name;
        this.location = location;
    }

}
