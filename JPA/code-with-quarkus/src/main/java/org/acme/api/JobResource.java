package org.acme.api;

import org.acme.model.CustomerDTO;
import org.acme.model.JobDTO;
import org.acme.workloads.Job.JobService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("job")
public class JobResource {

    private final JobService jobService;

    public JobResource(JobService jobService) {
        this.jobService = jobService;
    }

    @GET
    @Path("all")
    public Response getAllJobs() {
        var allJobs = this.jobService.getAllJobs();
        return Response.ok(allJobs).build();
    }

    @POST
    @Transactional
    public Response addJob(JobDTO newJob){
        var job = this.jobService.addJob(newJob);
        if (job == null){
            return Response.status(404).build();
        }
        return Response.ok(job).build();
    }

    @PUT
    @Transactional
    public Response update(JobDTO job) {
        jobService.updateJob(job);
        return Response.ok(job).build();
    }
}