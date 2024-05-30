package main.project.service;

import main.project.model.Customer;
import java.util.Map;
import java.util.HashMap;
import java.util.Collection;

public final class CustomerService {

    private static CustomerService custServiceInstance;

    private final Map<String, Customer> customersMaps;

    private CustomerService(){
        customersMaps = new HashMap<>();
    }


    // All Methods
    public void addCustomer(String firstName, String lastName, String email){
        if(customersMaps.containsKey(email)){
            throw new IllegalArgumentException("Customer with email " + email + " already exists");
        }
        else{
            customersMaps.put(email, new Customer(firstName, lastName, email));
        }
    }

    public Customer getCustomer(String customerEmail){
        if (customersMaps.containsKey(customerEmail)) {
            return customersMaps.get(customerEmail);
        }
        return null;
    }

    public Collection<Customer> getAllCustomers(){
        return customersMaps.values();
    }

    public static CustomerService getInstance(){
        if(custServiceInstance == null){
            custServiceInstance = new CustomerService();
        }
        return custServiceInstance;
    }
}
