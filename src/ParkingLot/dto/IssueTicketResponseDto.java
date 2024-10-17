package ParkingLot.dto;

import ParkingLot.models.Ticket;

public class IssueTicketResponseDto {

    private Ticket ticket;
    private int statusCode;
    private String message;

    public IssueTicketResponseDto(Ticket ticket, int statusCode, String message) {
        this.message = message;
        this.ticket = ticket;
        this.statusCode = statusCode;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
