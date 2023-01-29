package org.acme.api;

import org.acme.workloads.SummerWinter.SummerWinter;
import org.acme.workloads.SummerWinter.SummerWinterRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/summerwinter")
public class SummerWinterResource {

    private final SummerWinterRepo summerWinterRepo;

    public SummerWinterResource(SummerWinterRepo summerWinterRepo) {
        this.summerWinterRepo = summerWinterRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.summerWinterRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID/{id}")
    public Response getByID(@PathParam("id") Long id) {
        var found = this.summerWinterRepo.findById(id);
        return Response.ok(found).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(SummerWinter summerWinter){
        if (summerWinter == null){
            return Response.status(404).build();
        }
        this.summerWinterRepo.persist(summerWinter);
        return Response.ok(summerWinter).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(SummerWinter summerWinter) {
        summerWinterRepo.update(summerWinter);
        return Response.ok(summerWinter).build();
    }

    @DELETE
    @Transactional
    @Path("/delete/{id}")
    public Response delete(@PathParam("id") Long id) {
        summerWinterRepo.deleteById(id);
        return Response.ok(id).build();
    }
}