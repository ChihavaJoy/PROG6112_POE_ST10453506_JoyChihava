/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package moviebookingapp;
import models.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lab_services_student
 */
public class MovieBookingApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

     ArrayList<Screening> screenings = new ArrayList<>();
    ArrayList<Ticket> tickets = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

   // Create 5 popular 2025 movies
    Movie missionImpossible = new Movie("M1", "Mission: Impossible – The Final Reckoning", 140, "Action/Adventure");
    Movie dune = new Movie("M2", "Dune: Part Two", 156, "Sci‑Fi");
    Movie insideOut2 = new Movie("M3", "Inside Out 2", 95, "Animation");
    Movie superman = new Movie("M4", "Superman", 140, "Superhero");
    Movie electricState = new Movie("M5", "The Electric State", 120, "Sci‑Fi");

    // Link movies to screenings
    screenings.add(new Screening("S1", missionImpossible, 5));
    screenings.add(new Screening("S2", dune, 5));
    screenings.add(new Screening("S3", insideOut2, 5));
    screenings.add(new Screening("S4", superman, 5));
    screenings.add(new Screening("S5", electricState, 5));


    boolean running = true;
    while (running) {
        System.out.println("\n==============================");
        System.out.println("       CINEMA BOOKING APP      ");
        System.out.println("==============================");
        System.out.println("1. Book Ticket");
        System.out.println("2. View Screenings");
        System.out.println("3. View Tickets");
        System.out.println("4. Exit");
        System.out.println("------------------------------");
        System.out.print("Please enter your choice (1-4): ");

        String choice = scanner.nextLine().trim();

        switch (choice) {
            case "1":
                bookTicket(screenings, tickets, scanner);
                break;
            case "2":
                System.out.println("\n--- Current Screenings ---");
                if (screenings.isEmpty()) {
                    System.out.println("No screenings available.");
                } else {
                    for (Screening s : screenings) System.out.println(s);
                }
                break;
            case "3":
                System.out.println("\n--- All Booked Tickets ---");
                if (tickets.isEmpty()) {
                    System.out.println("No tickets booked yet.");
                } else {
                    for (Ticket t : tickets) System.out.println(t);
                }
                break;
            case "4":
                System.out.println("Thank you for using Cinema Booking App. Goodbye!");
                running = false;
                break;
            default:
                System.out.println("Invalid choice! Please select an option 1-4.");
        }
    }
    scanner.close();
}

    
     //Methods
    
        public static void bookTicket(ArrayList<Screening> screenings, ArrayList<Ticket> tickets, Scanner scanner) {
        if (screenings.isEmpty()) {
            System.out.println("No screenings available.");
            return;
        }

        // Display available screenings with ID and remaining seats
        System.out.println("\n=== Available Screenings ===");
        for (Screening s : screenings) {
            System.out.println("ID: " + s.getScreeningId() +
                   " | Movie: " + s.getMovie().getTitle() +
                   " | Genre: " + s.getMovie().getGenre() +
                   " | Duration: " + s.getMovie().getDuration() + " mins" +
                   " | Available Seats: " + s.getAvailableSeats());

        }
        System.out.println("============================");

        Screening selected = null;
        while (selected == null) {
            System.out.print("Enter Screening ID: ");
            String id = scanner.nextLine().trim();
            for (Screening s : screenings) {
                if (s.getScreeningId().equalsIgnoreCase(id)) {
                    selected = s;
                    break;
                }
            }
            if (selected == null) {
                System.out.println("Invalid screening ID! Try again.");
            }
        }

        if (selected.isFull()) {
            System.out.println("Sorry, screening is full.");
            return;
        }

        Ticket ticket = null;
        while (ticket == null) {
            System.out.print("Enter ticket type (Adult, Child, Senior): ");
            String type = scanner.nextLine().trim();
            switch (type.toLowerCase()) {
                case "adult":
                    ticket = new AdultTicket(selected);
                    break;
                case "child":
                    ticket = new ChildTicket(selected);
                    break;
                case "senior":
                    ticket = new SeniorTicket(selected);
                    break;
                default:
                    System.out.println("Invalid ticket type! Try again.");
            }
        }

        int seatNumber = selected.bookSeat(); // Book the next available seat
        ticket.setSeatNumber(seatNumber);     // Assign seat to ticket
        selected.confirmBooking(ticket);      // Confirm booking in screening
        tickets.add(ticket);                  // Save ticket in master list

        System.out.println("Ticket booked successfully: " + ticket);
    }

}
   

    


