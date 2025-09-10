/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author lab_services_student
 */
public class ChildTicket extends Ticket {
    
    public ChildTicket(Screening screening) {
        super(screening);
        setPrice(8.00);
    }

    @Override
    public String getType() { return "Child"; }
}

