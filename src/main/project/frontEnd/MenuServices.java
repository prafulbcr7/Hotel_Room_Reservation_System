package main.project.frontEnd;

import java.util.Scanner;

abstract class MenuServices {
    final Scanner scanner;
    public abstract void printMenu();

    MenuServices(Scanner scanner) {
        this.scanner = scanner;
    }

    boolean isNumber(String strInt) {
        if (strInt == null) {
            return false;
        }
        try {
            Double.parseDouble(strInt);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
