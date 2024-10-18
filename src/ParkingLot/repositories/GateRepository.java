package ParkingLot.repositories;

import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {

    Map<Long, Gate> gateMap = new HashMap<>();
    private long previousId = 0;

    public Gate findGateById(Long id) throws GateNotFoundException {
        if(gateMap.containsKey(id)) {
            return gateMap.get(id);
        }
        else throw new GateNotFoundException();
    }

    public void addGate(Gate g) {
        previousId++;
        gateMap.put(previousId, g);
    }

}
