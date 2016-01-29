package ua.di1.parking;

/**
 * Created by I on 26.01.2016.
 */
public class Parking {

    private int placesCount;
    private boolean isClosed = true;
    private Vehicle[] vehicles;

    public Parking(int placesCount, boolean isClosed) {
        this.placesCount = placesCount;
        this.isClosed = isClosed;
        vehicles = new Vehicle[placesCount];
    }

    public int getFreeParkingPlace(boolean ascending) {
        if (isClosed()){
            showMessageClosed();
            return -1;
        }

        int freePlace = findOnParking(true, ascending);

        if ( freePlace >= 0) return freePlace;

        this.close();
        return -1;
    }

    private void setClosed(boolean closed) {
        isClosed = closed;
    }

    public void close(){
        setClosed(true);
        showMessageClosed();
    }

    private void showMessageClosed(){
        System.out.println("Parking is CLOSED!");
    }

    public void open(){
        setClosed(false);
    }

    public boolean isClosed(){
        return isClosed;
    }

    private int findOnParking(boolean freePlace, boolean ascending){
        if (ascending){
            for ( int i = 0; i < placesCount; i++) {
                if ((freePlace)? (vehicles[i] == null) : (vehicles[i] != null)) return i;
            }
        }else {
            for (int i = placesCount - 1; i >= 0; i--) {
                if ((freePlace)? (vehicles[i] == null) : (vehicles[i] != null)) return i;
            }
        }
        return -1;
    }
    public int addMotoOnLastFreePlace(Vehicle vehicle) {
        int freeParkingPlace = getFreeParkingPlace(false);
        if (freeParkingPlace >=0 ){
            vehicles[freeParkingPlace] = vehicle;
        }
        return freeParkingPlace;
    }

    public boolean addMotoByPlaceNumber(Vehicle vehicle, int parkingPlace) {
        if (isClosed()) return false;
        if (parkingPlace >= placesCount) return false; // out of range
        if (vehicles[parkingPlace] != null) return false; // busy
        vehicles[parkingPlace] = vehicle;
        return true;
    }

    public Vehicle takeLastMoto() {
        if (isClosed()) return null;
        int parkingPlace = findOnParking(false, false);
        if ( parkingPlace >= 0){
            return vehicles[parkingPlace];
        }else {
            return null;
        }
    }

    public Vehicle takeMotoByPlaceNumber(int parkingPlace) {
        if (isClosed()) return null;
        if (parkingPlace >= placesCount) return null; // out of range
        return vehicles[parkingPlace];
    }

    public boolean clearGaragePlaces() {
        for (int i = 0; i < placesCount; i++) {
            vehicles[i] = null;
        }
        return true;
    }

    public int changeAddress(int parkingPlace) { // returns
        //if (isClosed()) return null;
        // if requester tries to put vehicle on any place and is getting -1 due to closed parking
        // he erroneously can think the place is busy and ask us to changeAddress while the place is empty(null)
        // to avoid changeAddress request on empty parking place we have to ...
        // how we have to handle changeAddress on empty place???
        int freeParkingPlace = findOnParking(true,true);
        if (parkingPlace >= placesCount) return -1; // out of range
        if (freeParkingPlace >=0 ){
            vehicles[freeParkingPlace] = vehicles[parkingPlace];
            vehicles[parkingPlace] = null;
        }else{
            showMessageParkingIsFull();
        }
        return freeParkingPlace;
    }

    private void showMessageParkingIsFull() {
        System.out.println("Parking is FULL!");
    }

    public String showAllInGarage() {
        String garageView = String.format("Garage with %d places", placesCount);
        String vehiclesView = "";

        int garageLength = ((int) Math.round(Math.sqrt(placesCount)));
        int linearPlace = 0;
        for (int i = 0; i < placesCount; i++) {
            if (linearPlace == 0) garageView += "\n|";

            garageView += (vehicles[i] == null)? "-" : "X";
            vehiclesView += (vehicles[i] == null)? ""
                                : ((vehiclesView.length() > 0) ? "," : "")
                                    + vehicles[i].getNumber();

            if (linearPlace == (garageLength-1)) {
                garageView += "|";
                garageView += " " + vehiclesView;

                vehiclesView = "";
                linearPlace = 0;
            }else{
                linearPlace++;
            }
        }

        if (garageView.charAt(garageView.length()-1) != '|') garageView+="|";
        return garageView;
    }
}
