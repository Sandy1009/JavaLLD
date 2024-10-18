package ParkingLot.models;

import ParkingLot.enums.VehicleType;

public class Vehicle {

    private String number;
    private String owner;
    private VehicleType vehicleType;

    public Vehicle(String number, String owner, VehicleType vehicleType) {
        this.number = number;
        this.owner = owner;
        this.vehicleType = vehicleType;
    }
}
