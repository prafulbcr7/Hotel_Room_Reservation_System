package main.project.model;

import java.util.regex.Pattern;

public class Customer {

    // variable declaration
    private String firstName, lastName, email;
    private String emailValidator = "^(.+)@(.+).(.+)$";

    //constructor
    public Customer(String firstName, String lastName, String email) {
        if (this.emailValidator(email)) {
            this.email = email;
        } else {
            throw new IllegalArgumentException("Email you entered is not in the Correct format. Please correct your email. (Its should be : ...@...com)");
        }

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getName() {return firstName + " " + lastName;}
    public String getEmail() {return email;}

    @Override
    public String toString() {return "Customers " + "First Name: " + firstName + " Last Name: " + lastName + " Email: " + email;}


    // Email Validation Method
    private boolean emailValidator(String email) {
        Pattern pattern = Pattern.compile(emailValidator);
        return pattern.matcher(email).matches();
    }

}
