package Source;

import org.bootcamp.vehicle.Bus;
import org.bootcamp.vehicle.Car;
import org.bootcamp.vehicle.Tipper;
import org.bootcamp.vehicle.Vehicle;

public class ConversionUtils {
    private ConversionUtils() {

    }

    public static Vehicle getVehicle(String vehicleName, int age, long numberOfMiles, boolean isDiesel)
    {
        final String carClassName = Car.class.getSimpleName().toUpperCase();
        final String busClassName = Bus.class.getSimpleName().toUpperCase();
        final String tipperClassName = Tipper.class.getSimpleName().toUpperCase();

        if (vehicleName.equals(carClassName)) {
            return new Car(age,numberOfMiles,isDiesel);
        }
        else if (vehicleName.equals(busClassName)) {
            return new Bus(age, numberOfMiles, isDiesel);
        }
        else if (vehicleName.equals(tipperClassName)) {
            return new Tipper(age,numberOfMiles,isDiesel);
        }
        return null;
    }
}

