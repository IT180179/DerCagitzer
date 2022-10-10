package org.acme.api;

import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Customer.CustomerRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/customer")
public class CustomerResource {

    private final CustomerRepo customerRepo;

    public CustomerResource(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.customerRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID/{id}")
    public Response getByID(@PathParam("id") Long id) {
        var found = this.customerRepo.findById(id);
        return Response.ok(found).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(Customer customer){
        if (customer == null){
            return Response.status(404).build();
        }
        this.customerRepo.persist(customer);
        return Response.ok(customer).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(Customer customer) {
        customerRepo.update(customer);
        return Response.ok(customer).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        customerRepo.deleteById(id);
        return Response.ok(id).build();
    }
}