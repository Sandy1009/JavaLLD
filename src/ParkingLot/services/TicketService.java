package ParkingLot.services;

import ParkingLot.dto.IssueTicketRequestDto;
import ParkingLot.enums.VehicleType;
import ParkingLot.exceptions.GateNotFoundException;
import ParkingLot.exceptions.ParkingSlotIsFullException;
import ParkingLot.models.*;
import ParkingLot.repositories.GateRepository;
import ParkingLot.repositories.ParkingLotRepository;
import ParkingLot.repositories.TicketRepository;
import ParkingLot.repositories.VehicleRepository;
import ParkingLot.strategies.AllotmentStrategy;

import java.util.Date;
import java.util.UUID;

public class TicketService {

    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private ParkingLotRepository parkingLotRepository;
    private TicketRepository ticketRepository;

    public Ticket issueTicket(IssueTicketRequestDto requestDto) throws GateNotFoundException, ParkingSlotIsFullException {

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Gate gate = gateRepository.findGateById(requestDto.getGateId());
        ticket.setEntryGate(gate);

        Vehicle vehicle = vehicleRepository.findByVehicleNumber(requestDto.getVehicleNumber());
        if(vehicle == null) {
            vehicle = new Vehicle(requestDto.getVehicleNumber(), requestDto.getOwnerName(), getEnumTypeFromString(requestDto.getVehicleType()));
        }
        ticket.setVehicle(vehicle);

        ParkingLot parkingLot = parkingLotRepository.findById(requestDto.getParkingLotId());
        AllotmentStrategy parkingSpaceAllocation = parkingLot.getAllotmentStrategy();

        ParkingSlot parkingSlot = parkingSpaceAllocation.getParkingSlot(getEnumTypeFromString(requestDto.getVehicleType()), requestDto.getParkingLotId());
        ticket.setParkingSlot(parkingSlot);

        ticket.setNumber(requestDto.getOwnerName()+ UUID.randomUUID());

        ticketRepository.saveTicket(ticket);

        return ticket;
    }

    private VehicleType getEnumTypeFromString(String vehicleType) {
        return VehicleType.valueOf(vehicleType);
    }
}
