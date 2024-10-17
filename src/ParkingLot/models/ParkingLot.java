package ParkingLot.models;

import java.util.List;
import ParkingLot.enums.*;
import ParkingLot.strategies.*;

public class ParkingLot {

    private List<ParkingFloor> floorList;
    private List<Gate> gateList;
    private ParkingLotStatus parkingLotStatus;

    private AllotmentStrategy allotmentStrategy;
    private BillingStrategy billingStrategy;

}
