package org.acme.workloads.Reservation;

import org.acme.model.JobDTO;
import org.acme.model.ReservationDTO;
import org.acme.workloads.Job.Job;
import org.acme.workloads.Restaurant.Restaurant;

import java.util.List;

public interface ReservationService {

    List<Reservation> getAllReservation();
    Reservation addReservation(ReservationDTO reservationDTO);
    Reservation updateReservation(ReservationDTO reservationDTO);
    Reservation deleteReservation(ReservationDTO reservationDTO);
    List<Restaurant> getReservationByRestaurantId(Long id);
    List<Restaurant> getReservationById(Long id);

}