package main.project.model;

public class FreeRoom extends Room{

    //Constructor
    public FreeRoom(String roomNumber, RoomType roomType){
        super(roomNumber, 0.0, roomType);
    }

    @Override
    public String toString() {
        return "Free of charge : " + super.toString();
    }
}
