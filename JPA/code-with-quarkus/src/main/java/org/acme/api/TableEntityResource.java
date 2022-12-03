package org.acme.api;

import org.acme.workloads.Job.Job;
import org.acme.workloads.Table_Entity.TableEntity;
import org.acme.workloads.Table_Entity.TableEntityRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/tables")
public class TableEntityResource {

    private final TableEntityRepo tableEntityRepo;

    public TableEntityResource(TableEntityRepo tableEntityRepo) {
        this.tableEntityRepo = tableEntityRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.tableEntityRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID/{id}")
    public Response getByID(@PathParam("id") Long id) {
        var found = this.tableEntityRepo.findById(id);
        return Response.ok(found).build();
    }

    @GET
    @Path("/getTablesPerRoom/{id}")
    public Response getTablesPerRoom(@PathParam("id") Long id) {
        var tables = this.tableEntityRepo.getTablesPerRoom(id);
        return Response.ok(tables).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(TableEntity tableEntity){
        if (tableEntity == null){
            return Response.status(404).build();
        }
        this.tableEntityRepo.persist(tableEntity);
        return Response.ok(tableEntity).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(TableEntity tableEntity) {
        tableEntityRepo.update(tableEntity);
        return Response.ok(tableEntity).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        tableEntityRepo.deleteById(id);
        return Response.ok(id).build();
    }
}
