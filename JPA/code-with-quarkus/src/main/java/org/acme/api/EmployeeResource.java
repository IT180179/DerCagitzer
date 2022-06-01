package org.acme.api;

import org.acme.model.CustomerDTO;
import org.acme.model.EmployeeDTO;
import org.acme.workloads.Customer.CustomerService;
import org.acme.workloads.Employee.EmployeeService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("employee")
public class EmployeeResource {

    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GET
    @Path("all")
    public Response getAllEmployees() {
        var allPeople = this.employeeService.getAllDrinks();
        return Response.ok(allPeople).build();
    }

    @GET
    @Path("{restaurantId}")
    public Response getAllEmployeesByRestaurantId(@PathParam("restaurantId") Long id) {
        employeeService.getAllEmployeesByRestaurantId(id);
        return Response.ok(id).build();
    }

    @POST
    @Transactional
    public Response addEmployee(EmployeeDTO newEmployee){
        if (newEmployee == null){
            return Response.status(404).build();
        }
        employeeService.addEmployee(newEmployee);
        return Response.ok(newEmployee).build();
    }

    @PUT
    @Transactional
    public Response update(EmployeeDTO newEmployee) {
        employeeService.updateEmployee(newEmployee);

        return Response.ok(newEmployee).build();
    }

}
