package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    private TicketRepository repository = new TicketRepository();
    private TicketManager manager = new TicketManager(repository);
    private Ticket spbMsk = new Ticket(1,3000, "LED", "DME", 90);
    private Ticket mskSpb = new Ticket(2,3200, "DME", "LED", 95);
    private Ticket spbSochi = new Ticket(3,9000, "LED", "AER", 200);
    private Ticket sochiSpb = new Ticket(4,10000, "AER", "LED", 190);
    private Ticket sochiMsk = new Ticket(5,8000, "AER", "DME", 180);
    private Ticket mskSochi = new Ticket(6,7500, "DME", "AER", 190);
    private Ticket spbMsk2 = new Ticket(7,2000, "LED", "DME", 90);
    private Ticket mskSpb2 = new Ticket(8,2800, "DME", "LED", 95);
    private Ticket spbSochi2 = new Ticket(9,9500, "LED", "AER", 200);
    private Ticket sochiSpb2 = new Ticket(10,9900, "AER", "LED", 190);
    private Ticket sochiMsk2 = new Ticket(11,7000, "AER", "DME", 180);


    @BeforeEach
    public void setUp() {
        repository.save(spbMsk);
        repository.save(mskSpb);
        repository.save(spbSochi);
        repository.save(sochiSpb);
        repository.save(sochiMsk);
        repository.save(mskSochi);
        repository.save(spbMsk2);
        repository.save(mskSpb2);
        repository.save(spbSochi);
        repository.save(spbSochi2);
        repository.save(sochiSpb2);
        repository.save(sochiMsk2);

    }

    @Test
    void searchAndSortTicket() {
        Ticket[] actual = manager.searchBy("LED", "DME");
        Ticket[] expected = new Ticket[]{spbMsk2, spbMsk};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searchTicket() {
        Ticket[] actual = manager.searchBy("DME", "AER" );
        Ticket[] expected = new Ticket[]{mskSochi};
        assertArrayEquals(expected, actual);
    }
    @Test
    void searchEmpty() {
        repository.removeById(2);
        repository.removeById(8);
        Ticket[] actual = manager.searchBy("DME", "LED");
        Ticket[] expected = new Ticket[0];
        assertArrayEquals(expected, actual);
    }

}