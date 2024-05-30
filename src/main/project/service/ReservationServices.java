package main.project.service;

import main.project.model.Customer;
import main.project.model.IRoom;
import main.project.model.ReservationClass;
import java.util.*;
import java.util.stream.Collectors;

public class ReservationServices {

    // static reference
    private static ReservationServices reservationServiceInstance;
    private final main.project.model.newReservation newestReservation;
    private final Map<String, IRoom> roomMap;

    private final Set<ReservationClass> reservations;

    // Constructor
    private ReservationServices(main.project.model.newReservation newestReservation) {
        this.newestReservation = newestReservation;
        this.roomMap = new HashMap<>();
        this.reservations = new HashSet<>();
    }

    // All Methods
    public void addRoom(IRoom room) {
        if(roomMap.containsKey(room.getRoomNumber())){
            throw new IllegalArgumentException("Room number " + room.getRoomNumber() + " already exists");
        }else{
            roomMap.put(room.getRoomNumber(), room);
        }
    }

    public Map<String, IRoom> getRooms() {
        return roomMap;
    }

    public IRoom getARoom(String roomId) {
        if (roomMap.containsKey(roomId)){
            return roomMap.get(roomId);
        }
        else{
            throw new IllegalArgumentException("There is no room with number " + roomId);
        }
    }

    public ReservationClass reserveARoom(Customer customer, IRoom room, Date checkInDate,
                                    Date checkOutDate) {
        ReservationClass newReservation = newestReservation.create(customer, room, checkInDate,
                checkOutDate);
        if (reservations.contains(newReservation)) {
            throw new IllegalArgumentException("This room is already reserved for these " +
                    "days");
        }
        reservations.add(newReservation);
        return newReservation;
    }

    public Collection<IRoom> findRooms(Date checkInDate, Date checkOutDate) {
        // Copy all rooms
        Map<String, IRoom> availableRooms = new HashMap<>(this.roomMap);

        // Compare with dates of existing reservations
        for (ReservationClass aReservation: this.reservations) {
            DatesCheckResult checkResult = checkDates(aReservation, checkInDate,
                    checkOutDate);
            boolean isCheckInOK = checkResult.isCheckInOK();
            boolean isCheckOutOK = checkResult.isCheckOutOK();
            if (! isCheckInOK || ! isCheckOutOK) {
                // Remove the room from the list of available rooms
                availableRooms.remove(aReservation.getIroom().getRoomNumber());
            }
        }

        return new ArrayList<>(availableRooms.values());
    }

    DatesCheckResult checkDates(ReservationClass reservation, Date checkIn, Date checkOut) {
        boolean isCheckInOK = checkIn.before(reservation.getCheckInDate()) ||
                checkIn.compareTo(reservation.getCheckOutDate()) >= 0;
        boolean isCheckOutOK = checkOut.compareTo(reservation.getCheckInDate()) <= 0 ||
                checkOut.after(reservation.getCheckOutDate());
        return new DatesCheckResult(isCheckInOK, isCheckOutOK);
    }

    record DatesCheckResult(boolean isCheckInOK, boolean isCheckOutOK) {}

    public Collection<ReservationClass> getCustomersReservation(Customer customer) {

        List<ReservationClass> customersReservations = new ArrayList<>();
        for (ReservationClass aReservation: this.reservations) {
            if (aReservation.getCustomer().equals(customer)) {
                customersReservations.add(aReservation);
            }
        }

        return customersReservations;
    }

    public Set<ReservationClass> getAllReservations() {
        return reservations;
    }

    public static ReservationServices getInstance(main.project.model.newReservation reservationFactory) {
        if (reservationServiceInstance == null) {
            reservationServiceInstance = new ReservationServices(reservationFactory);
        }

        return reservationServiceInstance;
    }
}
