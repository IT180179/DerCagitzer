package org.acme.api;

import io.smallrye.common.annotation.Blocking;
import org.acme.model.ReservationDTO;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.acme.workloads.Job.Job;
import org.acme.workloads.Reservation.Reservation;
import org.acme.workloads.Reservation.ReservationRepo;

import java.time.LocalDate;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/reservation")
public class ReservationResource {

    @Inject Mailer mailer;

    private final ReservationRepo reservationRepo;

    public ReservationResource(ReservationRepo reservationRepo) {
        this.reservationRepo = reservationRepo;
    }

    @GET
    @Blocking
    @Path("/sendEmail")
    public void sendEmail() {
        mailer.send(
                Mail.withText("ursprungdavid@gmail.com",
                        "Ahoy from Quarkus",
                        "A simple email sent from a Quarkus application."
                )
        );
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.reservationRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID")
    public Response getByID(Long id) {
        var found = this.reservationRepo.findById(id);
        return Response.ok(found).build();
    }

    @GET
    @Path("/getByDate")
    public Response getByDate(LocalDate date) {
        var foundReservation = this.reservationRepo.getByDate(date);
        return Response.ok(foundReservation).build();
    }

    @POST
    @Transactional
    @Path("/add")
    public Response add(Reservation reservation){
        if (reservation == null){
            return Response.status(404).build();
        }
        this.reservationRepo.persist(reservation);
        return Response.ok(reservation).build();
    }

    @PUT
    @Transactional
    @Path("/update")
    public Response update(Reservation reservation) {
        reservationRepo.update(reservation);
        return Response.ok(reservation).build();
    }

    @DELETE
    @Transactional
    @Path("/delete")
    public Response delete(Long id) {
        reservationRepo.deleteById(id);
        return Response.ok(id).build();
    }
}