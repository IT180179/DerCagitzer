package org.acme.workloads.Customer;

import org.acme.model.CustomerDTO;

import java.util.List;

public interface CustomerService {

    List<Customer> getAllCustomers();
    Long getMaxId();
    Customer addCustomer(CustomerDTO customerDTO);
    Customer updateCustomer(CustomerDTO customerDTO);
    Customer deleteCustomer(CustomerDTO customerDTO);
    Customer getCustomerById(Long id);

}