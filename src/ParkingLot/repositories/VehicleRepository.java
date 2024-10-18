package ParkingLot.repositories;

import ParkingLot.models.Vehicle;

import java.util.HashMap;
import java.util.Map;

public class VehicleRepository {

    Map<String, Vehicle> vehicleMap = new HashMap<>();

    public Vehicle findByVehicleNumber(String num) {
        if(vehicleMap.containsKey(num)) {
            return vehicleMap.get(num);
        }
        return null;
    }

}
