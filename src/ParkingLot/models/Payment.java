package ParkingLot.models;

import ParkingLot.enums.PaymentStatus;
import ParkingLot.enums.PaymentMode;

import java.util.Date;

public class Payment {

    private PaymentMode paymentMode;
    private float amount;
    private String refNumber;
    private PaymentStatus billingStatus;
    private Date time;

}
