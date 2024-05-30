package main.project.model;

public class Room implements IRoom {

    // variable Declaration
    private final RoomType roomType;
    private final String roomNumber;
    private final Double price;

    //constructor
    public Room(String roomNumber, Double price, RoomType roomType) {
        this.roomNumber = roomNumber;
        this.price = price;
        this.roomType = roomType;
    }

    @Override
    public String getRoomNumber(){return roomNumber;}

    @Override
    public Double getRoomPrice() {return price;}

    @Override
    public RoomType getRoomType() {
        return roomType;
    }

    @Override
    public boolean isFree() {
        return false;
    }

    @Override
    public String toString(){
        return "Room number: " + roomNumber + ", Price: " + price +
                ", Room Type: " + roomType + ".";
    }
}
