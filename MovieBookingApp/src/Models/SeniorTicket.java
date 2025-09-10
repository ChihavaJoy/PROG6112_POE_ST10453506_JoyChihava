/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lab_services_student
 */
public class SeniorTicket extends Ticket {
    public SeniorTicket(Screening screening) {
        super(screening);
        setPrice(10.00);
    }

    @Override
    public String getType() { return "Senior"; }
}