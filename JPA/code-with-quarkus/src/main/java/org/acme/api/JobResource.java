package org.acme.api;

import org.acme.model.JobDTO;
import org.acme.workloads.Customer.Customer;
import org.acme.workloads.Job.Job;
import org.acme.workloads.Job.JobRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/job")
public class JobResource {

    private final JobRepo jobRepo;

    public JobResource(JobRepo jobRepo) {
        this.jobRepo = jobRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.jobRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID/{id}")
    public Response getByID(@PathParam("id") Long id) {
        var found = this.jobRepo.findById(id);
        return Response.ok(found).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(Job job){
        if (job == null){
            return Response.status(404).build();
        }
        this.jobRepo.persist(job);
        return Response.ok(job).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(Job job) {
        jobRepo.update(job);
        return Response.ok(job).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        jobRepo.deleteById(id);
        return Response.ok(id).build();
    }
}