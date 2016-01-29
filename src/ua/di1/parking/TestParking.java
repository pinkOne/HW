package ua.di1.parking;
import static ua.di1.Test.checkResult;
/**
 * Created by I on 27.01.2016.
 */
public class TestParking {
    public static void main(String[] args) {
        testAddMotoOnLastFreePlace();
        testTakeLastMoto();
        testAddMotoByPlaceNumber();
        testTakeMotoByPlaceNumber();
        testClearGaragePlaces();
        testOpen();
        testClose();
        testChangeAddress();
        testShowAllInGarage();
    }

    private static void testShowAllInGarage() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(27, false);
        parking.addMotoByPlaceNumber(moto, 16);
        moto = new Vehicle("VW", "SX 143");
        parking.addMotoByPlaceNumber(moto, 15);

        String garageView = parking.showAllInGarage();
        System.out.println("\n" + garageView);
        checkResult("testShowAllInGarage",
                garageView.length() > 0
        );
    }

    private static void testChangeAddress() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, false);
        checkResult("testChangeAddress when parking place is empty.",
                parking.changeAddress(15) >= 0
                        && parking.takeMotoByPlaceNumber(15) == null
        );

        parking.addMotoByPlaceNumber(moto, 15);

        checkResult("testChangeAddress",
                parking.changeAddress(15) >= 0
                && parking.takeMotoByPlaceNumber(15) == null
                && parking.takeMotoByPlaceNumber(0) != null
        );
    }

    private static void testClose() {
        Parking parking = new Parking(20, false);
        parking.close();
        checkResult("testClose",
                parking.isClosed()
        );
    }

    private static void testOpen() {
        Parking parking = new Parking(20, true);
        parking.open();
        checkResult("testOpen",
                !parking.isClosed()
        );
    }

    private static void testClearGaragePlaces() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, false);
        parking.addMotoByPlaceNumber(moto, 15);
        checkResult("testClearGaragePlaces",
                parking.clearGaragePlaces()
                && (parking.takeLastMoto() == null)
        );
    }

    private static void testTakeMotoByPlaceNumber() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, false);
        parking.addMotoByPlaceNumber(moto, 15);
        checkResult("testTakeMotoByPlaceNumber",
                parking.takeMotoByPlaceNumber(15).getNumber() == moto.getNumber()
        );
    }

    private static void testAddMotoByPlaceNumber() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, false);
        checkResult("testAddMotoByPlaceNumber",
                parking.addMotoByPlaceNumber(moto, 15)
        );
        checkResult("testAddMotoByPlaceNumber when place is busy.",
                !parking.addMotoByPlaceNumber(moto, 15)
        );
    }

    private static void testTakeLastMoto() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, false);

        checkResult("testTakeLastMoto on empty parking.",
                parking.takeLastMoto() == null
        );

        parking.addMotoOnLastFreePlace(moto);
        String lastVehicleNumber = moto.getNumber();

        moto = new Vehicle("VW", "KA 1256");
        parking.addMotoOnLastFreePlace(moto);
        checkResult("testTakeLastMoto",
                parking.takeLastMoto().getNumber().equals(lastVehicleNumber)
        );
    }

    private static void testAddMotoOnLastFreePlace() {
        Vehicle moto = new Vehicle("BMW", "BM 4598");
        Parking parking = new Parking(20, true);
        int result = parking.addMotoOnLastFreePlace(moto);
        checkResult("testAddMotoOnLastFreePlace when parking is closed.",
                result < 0
        );
        parking = new Parking(20, false);
        result = parking.addMotoOnLastFreePlace(moto);
        checkResult("testAddMotoOnLastFreePlace",
                result >= 0
                && parking.getFreeParkingPlace(false) == 18
        );
    }
}
