package ParkingLot.strategies;

import ParkingLot.enums.VehicleType;

public interface BillingStrategy {

    Double calculateBillAmount(VehicleType vechileType, long ticketId);

}
