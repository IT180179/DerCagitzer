package org.acme.api;

import io.smallrye.common.annotation.Blocking;
import org.acme.model.ReservationDTO;
import org.acme.workloads.Reservation.ReservationService;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("reservation")
public class ReservationResource {

    @Inject Mailer mailer;

    private final ReservationService reservationService;

    public ReservationResource(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GET
    @Blocking
    public void sendEmail() {
        mailer.send(
                Mail.withText("ursprungdavid@gmail.com",
                        "Ahoy from Quarkus",
                        "A simple email sent from a Quarkus application."
                )
        );
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
}
