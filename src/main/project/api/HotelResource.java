package main.project.api;

import main.project.model.Customer;
import main.project.model.IRoom;
import main.project.model.ReservationClass;
import main.project.service.CustomerService;
import main.project.service.ReservationServices;

import java.util.*;

public class HotelResource {

    private final ReservationServices reservationServices;
    private final CustomerService customerService;


    //Constructor
    public HotelResource(ReservationServices reservationServices, CustomerService customerService) {
        this.reservationServices = reservationServices;
        this.customerService = customerService;
    }

    //All Methods
    public Customer getCustomer(String customerEmail){
        return customerService.getCustomer(customerEmail);
    }

    public void createACustomer(String firstName, String lastName, String email){
        customerService.addCustomer(firstName, lastName, email);
    }

    public IRoom getRoom(String roomNumber){
        return reservationServices.getARoom(roomNumber);
    }

    public ReservationClass bookARoom( String customerEmail, IRoom room, Date checkInDate, Date checkOutDate){
        Customer customer = getCustomer(customerEmail);
        return reservationServices.reserveARoom(customer, room, checkInDate, checkOutDate);
    }

    public Collection<IRoom> findARoom(Date checkIn, Date checkOut) {
        return reservationServices.findRooms(checkIn, checkOut);
    }

    public Collection<ReservationClass> getCustomersReservation(String customerEmail){
        Customer customer = getCustomer(customerEmail);
        return reservationServices.getCustomersReservation(customer);
    }
}
