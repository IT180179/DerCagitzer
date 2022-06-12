package org.acme.api;

import org.acme.model.CustomerDTO;
import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Customer.CustomerService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("customer")
public class CustomerResource {

    private final CustomerService customerService;

    public CustomerResource(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GET
    @Path("all")
    public Response getAllCostumers() {
        var allPeople = this.customerService.getAllCustomers();
        return Response.ok(allPeople).build();
    }

    @POST
    @Transactional
    public Response addCostumer(CustomerDTO newCustomer){
        var customer = this.customerService.addCustomer(newCustomer);
        if (customer == null){
            return Response.status(404).build();
        }
        return Response.ok(customer).build();
    }

    @PUT
    @Transactional
    public Response update(CustomerDTO customer) {
            customerService.updateCustomer(customer);
            return Response.ok(customer).build();
    }

}