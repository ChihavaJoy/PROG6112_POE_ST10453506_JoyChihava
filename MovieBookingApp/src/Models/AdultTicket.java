/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lab_services_student
 */
public class AdultTicket extends Ticket {
   public AdultTicket(Screening screening) {
        super(screening);
        setPrice(12.50);
    }

    @Override
    public String getType() { return "Adult"; }
}

