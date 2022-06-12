package org.acme.api;

import org.acme.workloads.Room.RoomService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("room")
public class RoomResource {

    private final RoomService roomService;

    public RoomResource(RoomService roomService) {
        this.roomService = roomService;
    }
    @GET
    @Path("{roomId}")
    public Response getRoomsById(@PathParam("roomId") Long id) {
        var rooms = this.roomService.getRoomsById(id);
        return Response.ok(rooms).build();
    }

    @GET
    @Path("all")
    public Response getAll() {
        var allTables = this.roomService.getAllRooms();
        return Response.ok(allTables).build();
    }
}
