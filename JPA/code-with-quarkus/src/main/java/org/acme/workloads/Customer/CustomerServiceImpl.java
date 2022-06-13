package org.acme.workloads.Customer;

import org.acme.model.CustomerDTO;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepo customerRepo;

    public CustomerServiceImpl(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return this.customerRepo.getAllCustomers();
    }

    @Override
    public Long getMaxId() {
        return this.customerRepo.getMaxId();
    }

    @Override
    public Customer addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirst_name(customerDTO.getFirst_name());
        customer.setLast_name(customerDTO.getLast_name());
        customer.setEmail(customerDTO.getEmail());
        customer.setTelNr(customerDTO.getTelNr());
        customer.setPassword(customerDTO.getPassword());
        this.customerRepo.add(customer);
        return customer;
    }

    @Override
    public Customer updateCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirst_name(customerDTO.getFirst_name());
        customer.setLast_name(customerDTO.getLast_name());
        customer.setEmail(customerDTO.getEmail());
        customer.setTelNr(customerDTO.getTelNr());
        customer.setPassword(customerDTO.getPassword());
        this.customerRepo.update(customer);
        return customer;
    }

    @Override
    public Customer deleteCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setFirst_name(customerDTO.getFirst_name());
        customer.setLast_name(customerDTO.getLast_name());
        customer.setEmail(customerDTO.getEmail());
        customer.setTelNr(customerDTO.getTelNr());
        customer.setPassword(customerDTO.getPassword());
        this.customerRepo.delete(customer);
        return customer;
    }

    @Override
    public Customer getCustomerById(Long id) {
        return customerRepo.getCustomerById(id);
    }
}