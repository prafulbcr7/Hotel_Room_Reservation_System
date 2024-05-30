package main.project.model;

import java.util.Date;

public final class newReservation {
    public ReservationClass create(Customer customer, IRoom iroom, Date checkInDate, Date checkOutDate){
        return new ReservationClass(customer, iroom, checkInDate, checkOutDate);
    }
}
