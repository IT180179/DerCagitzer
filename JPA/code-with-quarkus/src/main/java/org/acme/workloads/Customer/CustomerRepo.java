package org.acme.workloads.Customer;

import org.acme.model.CustomerDTO;

import java.util.List;

public interface CustomerRepo {

    List<Customer> getAllCustomers();
    void add(Customer customer);
    void update(Customer customer);
    void delete(Customer customer);
    Customer getCustomerById(Long id);

}