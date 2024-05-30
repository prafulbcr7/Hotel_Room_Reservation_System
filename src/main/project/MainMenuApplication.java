package main.project;

import main.project.api.*;
import main.project.frontEnd.*;
import main.project.model.newReservation;
import main.project.service.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public final class MainMenuApplication {
    public static void main(String[] args) {
        // Instantiate classes
        CustomerService customerService = CustomerService.getInstance();
        ReservationServices reservationService = ReservationServices.getInstance(new newReservation());
        AdminResource adminResource = new AdminResource(customerService, reservationService);
        Scanner scanner = new Scanner(System.in);
        DateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
        ConsolePrinter consolePrinter = new ConsolePrinterImplement();
        AdminMenuServices adminMenuService = new AdminMenuServices(adminResource, scanner, consolePrinter);
        MenuManager adminMenuManager = new AdminMenuManager(scanner, adminMenuService, consolePrinter);
        HotelResource hotelResource = new HotelResource(reservationService, customerService);
        Date now = new Date();
        MainMenuServices mainMenuService = new MainMenuServices(now, hotelResource, scanner, simpleDateFormat, consolePrinter);
        MenuManager mainMenuManager = new MainMenuManager(adminMenuManager, mainMenuService, scanner, consolePrinter);

        // Run the app
        mainMenuManager.open();
    }
}
