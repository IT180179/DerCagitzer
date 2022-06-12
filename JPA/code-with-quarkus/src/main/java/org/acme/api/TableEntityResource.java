package org.acme.api;
import org.acme.workloads.Table_Entity.TableEntityService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("tables")
public class TableEntityResource {

    private final TableEntityService tableEntityService;

    public TableEntityResource(TableEntityService tableEntityService) {
        this.tableEntityService = tableEntityService;
    }

    @GET
    @Path("{restaurantId}")
    public Response getAllTablesByRestaurantId(@PathParam("restaurantId") Long id) {
        var allTables = this.tableEntityService.getAllTablesByRestaurantId(id);
        return Response.ok(allTables).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        var allTables = this.tableEntityService.getAllTables();
        return Response.ok(allTables).build();
    }
}
