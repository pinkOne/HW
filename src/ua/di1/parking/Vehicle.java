package ua.di1.parking;

/**
 * Created by I on 27.01.2016.
 */
public class Vehicle {
    private String number;
    private String manufacturer;

    public Vehicle(String manufacturer, String number) {
        this.number = number;
        this.manufacturer = manufacturer;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNumber() {

        return number;
    }
}
