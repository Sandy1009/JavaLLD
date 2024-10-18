package ParkingLot.strategies;

import ParkingLot.enums.ParkingSlotStatus;
import ParkingLot.enums.VehicleType;
import ParkingLot.exceptions.ParkingSlotIsFullException;
import ParkingLot.models.ParkingFloor;
import ParkingLot.models.ParkingLot;
import ParkingLot.models.ParkingSlot;
import ParkingLot.repositories.ParkingLotRepository;

public class EmptySlotAllocationStrategy implements AllotmentStrategy {

    private ParkingLotRepository parkingLotRepository;

    @Override
    public ParkingSlot getParkingSlot(VehicleType vechileType, long parkingLotId) throws ParkingSlotIsFullException {

        ParkingLot parkingLot = parkingLotRepository.findById(parkingLotId);

        for(ParkingFloor floor : parkingLot.getFloorList()) {
            for(ParkingSlot slot : floor.getParkingSlotList()) {
                if(slot.getVechileType().equals(vechileType)) {
                    if(ParkingSlotStatus.EMPTY.equals(slot.getParkingSlotStatus())) {
                        return slot;
                    }
                }
            }
        }

        throw new ParkingSlotIsFullException();
    }

}
