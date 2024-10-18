package ParkingLot.repositories;

import ParkingLot.models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    Map<Long, Ticket> ticketMap = new HashMap<>();
    private long previousId = 0;

    public void saveTicket(Ticket ticket) {
        previousId++;
        ticketMap.put(previousId, ticket);
    }

}
