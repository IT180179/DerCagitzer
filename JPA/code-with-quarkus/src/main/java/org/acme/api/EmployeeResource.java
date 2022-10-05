package org.acme.api;

import org.acme.model.EmployeeDTO;
import org.acme.workloads.Employee.Employee;
import org.acme.workloads.Employee.EmployeeRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("employee")
public class EmployeeResource {

    private final EmployeeRepo employeeRepo;

    public EmployeeResource(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.employeeRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/all")
    public Response getById(Long id) {
        var found = this.employeeRepo.findById(id);
        return Response.ok(found).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response addEmployee(Employee employee){
        if (employee == null){
            return Response.status(404).build();
        }
        employeeRepo.persist(employee);
        return Response.ok(employee).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(Employee employee) {
        employeeRepo.update(employee);
        return Response.ok(employee).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        employeeRepo.deleteById(id);
        return Response.ok(id).build();
    }
}