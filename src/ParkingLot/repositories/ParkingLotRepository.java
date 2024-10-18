package ParkingLot.repositories;

import ParkingLot.models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {

    private Map<Long, ParkingLot> parkingLotMap = new HashMap<>();

    public ParkingLot findById(long id) {
        if(parkingLotMap.containsKey(id)) {
            return parkingLotMap.get(id);
        }
        return null;
    }

}
