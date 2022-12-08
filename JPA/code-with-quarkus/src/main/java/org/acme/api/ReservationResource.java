package org.acme.api;

import io.smallrye.common.annotation.Blocking;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import io.quarkus.mailer.Mail;
import io.quarkus.mailer.Mailer;
import org.acme.workloads.Reservation.Reservation;
import org.acme.workloads.Reservation.ReservationRepo;
import org.acme.workloads.Table_Entity.TableEntityRepo;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("/reservation")
public class ReservationResource {

    @Inject Mailer mailer;

    private final ReservationRepo reservationRepo;
    private final TableEntityRepo tableEntityRepo;

    public ReservationResource(ReservationRepo reservationRepo, TableEntityRepo tableEntityRepo) {
        this.reservationRepo = reservationRepo;
        this.tableEntityRepo = tableEntityRepo;
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
    @Path("/countReservationsPerTimeslot/{start_time}/{end_time}/{date}")
    public Response countReservationsPerTimeslot(@PathParam("start_time") String start_time, @PathParam("end_time") String end_time, @PathParam("date") String date) {
        var countedReservations = this.reservationRepo.countReservationsPerTimeslot(start_time, end_time, date);
        return Response.ok(countedReservations).build();
    }

    @GET
    @Path("/countReservationsPerDay/{date}")
    public Response countReservationsPerDay(@PathParam("date") String date) {
        var countedReservations = this.reservationRepo.countReservationsPerDay(date);
        return Response.ok(countedReservations).build();
    }

    @GET
    @Path("/countPersonsPerDay/{date}")
    public Response countPersonsPerDay(@PathParam("date") String date) {
        var countedReservations = this.reservationRepo.countPersonsPerDay(date);
        return Response.ok(countedReservations).build();
    }

    @GET
    @Path("/all")
    public Response getAll() {
        var all = this.reservationRepo.listAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/getByID/{id}")
    public Response getByID(@PathParam("id") Long id) {
        var found = this.reservationRepo.findById(id);
        return Response.ok(found).build();
    }

    @GET
    @Path("/getByDate/{date}")
    public Response getByDate(@PathParam("date") String date) {
        var foundReservation = this.reservationRepo.getByDate(date);
        return Response.ok(foundReservation).build();
    }

    @GET
    @Path("/calculateReservationsPerDayNoon/{date}")
    public Response calculateReservationsPerDayNoon(@PathParam("date") String date) {
        var usageNoon = this.reservationRepo.countReservationsPerDayNoon(date);
        var seats = this.tableEntityRepo.countSeats();
        Double resultNoon = Double.valueOf(usageNoon) / (seats * 2);
        return Response.ok(resultNoon).build();
    }

    @GET
    @Path("/calculateReservationsPerDayEvening/{date}")
    public Response calculateReservationsPerDayEvening(@PathParam("date") String date) {
        var usageEvening = this.reservationRepo.countReservationsPerDayEvening(date);
        var seats = this.tableEntityRepo.countSeats();
        Double resultEvening = Double.valueOf(usageEvening) / (seats * 2);
        return Response.ok(resultEvening).build();
    }

    @GET
    @Path("/calculateReservationsPerWeek/{start_date}/{end_date}")
    public Response calculateReservationsPerWeek(@PathParam("start_date") String start_date, @PathParam("end_date") String end_date) {
        var usageWeek = this.reservationRepo.countReservationsPerWeek(start_date, end_date);
        var seats = this.tableEntityRepo.countSeats();
        Double resultEvening = Double.valueOf(usageWeek) / ((seats * 4) * 7);
        return Response.ok(resultEvening).build();
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