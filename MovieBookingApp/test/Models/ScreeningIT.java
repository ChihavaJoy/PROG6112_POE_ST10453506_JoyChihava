/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Models;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import models.Movie;
import models.Screening;
import models.AdultTicket; // if AdultTicket is also in Models



/**
 *
 * @author lab_services_student
 */
public class ScreeningIT {
    
    private Movie movie;
    private Screening screening;

    @Before
    public void setUp() {
        // Create a movie and a screening with capacity 2
        movie = new Movie("M1", "Test Movie", 120, "Action");
        screening = new Screening("S1", movie, 2);
    }
    
    public ScreeningIT() {
    }


    /**
     * Test of bookSeat method, of class Screening.
     */
    @Test
    public void testBookSeat() {
         // Initially, there should be 2 available seats
        assertEquals(2, screening.getAvailableSeats());

        // Book first seat
        int seat1 = screening.bookSeat();
        assertEquals(1, seat1); // Seat numbers are 1-based
        assertEquals(1, screening.getBookedTickets().size());
        assertFalse(screening.isFull());

        // Book second seat
        int seat2 = screening.bookSeat();
        assertEquals(2, seat2);
        assertTrue(screening.isFull());

        // Trying to book when full should return -1
        int seat3 = screening.bookSeat();
        assertEquals(-1, seat3);
    }

    /**
     * Test of confirmBooking method, of class Screening.
     */
    @Test
    public void testConfirmBooking() {
         AdultTicket ticket = new AdultTicket(screening);
        int seat = screening.bookSeat();
        ticket.setSeatNumber(seat);
        screening.confirmBooking(ticket);

        assertEquals(ticket, screening.getBookedTickets().get(seat - 1));
        assertEquals(1, screening.getBookedTickets().size());
    }

   
    
}
