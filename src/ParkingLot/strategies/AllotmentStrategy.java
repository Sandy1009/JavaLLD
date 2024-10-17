package ParkingLot.strategies;

import ParkingLot.enums.VehicleType;
import ParkingLot.models.ParkingSlot;

public interface AllotmentStrategy {

    ParkingSlot getParkingSlot(VehicleType vechileType, long parkingLotId);

}
