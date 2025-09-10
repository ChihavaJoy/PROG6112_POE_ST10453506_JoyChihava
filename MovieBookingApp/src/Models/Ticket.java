/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lab_services_student
 */
public abstract class Ticket {
    
  private int seatNumber;
    private double price;
    private Screening screening;

    public Ticket(Screening screening) {
        this.screening = screening;
    }

    public int getSeatNumber() { return seatNumber; }
    public void setSeatNumber(int seatNumber) { this.seatNumber = seatNumber; }

    public double getPrice() { return price; }
    protected void setPrice(double price) { this.price = price; }

    public Screening getScreening() { return screening; }

    public abstract String getType();

    @Override
    public String toString() {
        return String.format("%s Ticket | Movie: %s | Seat %d | Price: $%.2f",
                             getType(),
                             getScreening().getMovie().getTitle(),
                             seatNumber,
                             price);
    }

}
