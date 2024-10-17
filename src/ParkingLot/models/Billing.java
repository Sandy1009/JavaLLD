package ParkingLot.models;

import ParkingLot.enums.PaymentStatus;

import java.util.Date;
import java.util.List;

public class Billing {

    private Date exitTime;
    private Ticket ticket;
    private float billingAmount;
    private PaymentStatus status;
    private List<Payment> paymentList;
    private Gate exitGate;
    private String operator;

}
