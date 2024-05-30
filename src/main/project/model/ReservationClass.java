package main.project.model;

import java.util.Date;

public class ReservationClass {

    // variable Declaration
    private final Customer customer;
    private final IRoom iroom;
    private final Date checkInDate;
    private final Date checkOutDate;

    //Constructor
    public ReservationClass(Customer customer, IRoom iroom, Date checkInDate, Date checkOutDate){
        this.customer = customer;
        this.iroom = iroom;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    //getters
    public Customer getCustomer() {return customer;}
    public IRoom getIroom() {return iroom;}
    public Date getCheckInDate() {return checkInDate;}
    public Date getCheckOutDate() {return checkOutDate;}

    @Override
    public String toString() {
        return "Room reservation for "+ "Customer: " + this.customer.toString()
                + "Room: " + this.iroom.toString()
                + "CheckIn Date: " + this.checkInDate
                + "CheckOut Date: " + this.checkOutDate;
    }
}
