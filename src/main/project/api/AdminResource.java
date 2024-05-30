package main.project.api;

import main.project.model.Customer;
import main.project.model.IRoom;
import main.project.model.ReservationClass;
import main.project.service.CustomerService;
import main.project.service.ReservationServices;

import java.util.*;

public class AdminResource {

    private final ReservationServices reservationServices;
    private final CustomerService customerService;

    public AdminResource(CustomerService customerService, ReservationServices reservationService) {
        this.customerService = customerService;
        this.reservationServices = reservationService;
    }

    public Customer getCustomer(String email) {
        return customerService.getCustomer(email);
    }

    public void addRoom(List<IRoom> rooms) {

        for (IRoom newRoom: rooms) {
            reservationServices.addRoom(newRoom);
        }
    }

    public Collection<IRoom> getAllRooms() {

        Map<String, IRoom> allRooms = reservationServices.getRooms();
        return new ArrayList<>(allRooms.values());
    }

    public Collection<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    public Set<ReservationClass> displayAllReservations() {
        return reservationServices.getAllReservations();
    }
}
