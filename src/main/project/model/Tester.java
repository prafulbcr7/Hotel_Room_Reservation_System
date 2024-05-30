package main.project.model;

public class Tester {

    //Main
    public static void main(String[] args) {

        String email = "first.last@gmail.com";
        Customer customer = new Customer("first", "last", email);
        System.out.println(customer);

        //Room Class
        RoomType roomType = null;
        Room room = new Room("101", 185.56, roomType.DOUBLE);
        System.out.println(room);

    }
}
