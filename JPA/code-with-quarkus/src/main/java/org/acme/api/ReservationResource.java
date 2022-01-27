package org.acme.api;

import org.acme.model.ReservationDTO;
import org.acme.workloads.Reservation.ReservationService;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/Reservierungen")
public class ReservationResource {

    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @Transactional
    @POST
    public Response addReservation(ReservationDTO reservationDTO){
        return null;
    }
    @Path("/all")
    @GET
    @Produces
    public Response getAll(){
        var reservations = reservationService.getAllReservations();

        return Response.ok(reservations).build();
    }
}
