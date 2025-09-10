/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;
import java.util.ArrayList;
/**
 *
 * @author lab_services_student
 */
public class Screening {
    
    private String screeningId;
    private int capacity;
    private Movie movie;
    private ArrayList<Ticket> bookedTickets = new ArrayList<>();
    
     public Screening(String screeningId, Movie movie, int capacity) {
        this.screeningId = screeningId;
        this.movie = movie;
        this.capacity = capacity;
    }
    
     public String getScreeningId() { return screeningId; }
     public Movie getMovie() { return movie; }
     
     public boolean isFull() {
        return bookedTickets.size() >= capacity;
     }
     
     public int bookSeat() {
        if (isFull()) return -1;
        bookedTickets.add(null);
        return bookedTickets.size(); // seat number = 1-based
    }
     
    public void confirmBooking(Ticket ticket) {
        bookedTickets.set(ticket.getSeatNumber() - 1, ticket);
    }

    public int getAvailableSeats() {
        return capacity - bookedTickets.size();
    }

    public ArrayList<Ticket> getBookedTickets() {
        return bookedTickets;
    }

    @Override
    public String toString() {
        return "Screening ID: " + screeningId +
               " | Movie: " + movie.getTitle() +
               " | Genre: " + movie.getGenre() +
               " | Duration: " + movie.getDuration() + " mins" +
               " | Seats: " + bookedTickets.size() + "/" + capacity;
    }
}
