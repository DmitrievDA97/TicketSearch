package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

public class TicketManager {
    private TicketRepository repository;
    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket[] searchBy(String airportFrom, String airportIn) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, airportFrom, airportIn)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;

    }
    public boolean matches(Ticket ticket, String searchFrom, String searchIn) {
        if (ticket.getAirportFrom().equalsIgnoreCase(searchFrom) && ticket.getAirportIn().equalsIgnoreCase(searchIn)) {
            return true;
        }
        return false;
    }
}