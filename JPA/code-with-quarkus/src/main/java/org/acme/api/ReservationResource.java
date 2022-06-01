package org.acme.api;

import org.acme.model.ReservationDTO;
import org.acme.workloads.Reservation.ReservationService;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("reservation")
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @POST
    @Transactional
    public Response addReservation(ReservationDTO newReservation){
        if (newReservation == null){
            return Response.status(404).build();
        }
        reservationService.addReservation(newReservation);
        return Response.ok(newReservation).build();
    }
    @DELETE
    @Transactional
    public Response deleteReservation(ReservationDTO reservationDTO){
        if (reservationDTO == null){
            return Response.status(404).build();
        }
        reservationService.deleteReservation(reservationDTO);
        return Response.ok(reservationDTO).build();
    }
    @GET
    @Path("all")
    public Response getAllReservations() {
        var allReservation = this.reservationService.getAllReservation();
        return Response.ok(allReservation).build();
    }

    @GET
    @Path("{reservationId}")
    public Response getReservationById(@PathParam("reservationId") Long id) {
        var reservation = this.reservationService.getReservationById(id);
        return Response.ok(reservation).build();
    }

    @GET
    @Path("{restaurantId}")
    public Response getReservationsByRestaurantId(@PathParam("restaurantId") Long id) {
        var reservation = this.reservationService.getReservationByRestaurantId(id);
        return Response.ok(reservation).build();
    }
}
