package ParkingLot.controller;

import ParkingLot.dto.IssueTicketRequestDto;
import ParkingLot.dto.IssueTicketResponseDto;
import ParkingLot.models.Ticket;
import ParkingLot.services.TicketService;

public class IssueTicketController {

    private TicketService ticketService;

    public IssueTicketResponseDto issueTicket(IssueTicketRequestDto requestDto) {

        Ticket ticket = ticketService.issueTicket(requestDto);

        if(ticket != null) {
            return new IssueTicketResponseDto(ticket, 200, "Ticket Issued");
        } else {
            return new IssueTicketResponseDto(null, 500, "Ticket Not Issued");
        }

    }

}
