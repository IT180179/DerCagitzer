package org.acme.api;

import org.acme.workloads.Job.Job;
import org.acme.workloads.Room.Room;
import org.acme.workloads.Room.RoomRepo;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("room")
public class RoomResource {

    private final RoomRepo roomRepo;

    public RoomResource(RoomRepo roomRepo) {
        this.roomRepo = roomRepo;
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.roomRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID")
    public Response getByID(Long id) {
        var found = this.roomRepo.findById(id);
        return Response.ok(found).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(Room room){
        if (room == null){
            return Response.status(404).build();
        }
        this.roomRepo.persist(room);
        return Response.ok(room).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(Room room) {
        roomRepo.update(room);
        return Response.ok(room).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        roomRepo.deleteById(id);
        return Response.ok(id).build();
    }
}
